package com.uyac.test.utils;

import android.support.annotation.NonNull;

import com.blankj.utilcode.util.NetworkUtils;
import com.orhanobut.logger.Logger;
import com.uyac.test.constants.Constants;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by noah on 2017/4/25.
 */

public class RetrofitUtils {

        //设缓存有效期为1天
        static final long CACHE_STALE_SEC = 60 * 60 * 24 * 1;
        //查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
        private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
        //查询网络的Cache-Control设置
        //(假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)
        static final String CACHE_CONTROL_NETWORK = "Cache-Control: public, max-age=3600";
        // 避免出现 HTTP 403 Forbidden，参考：http://stackoverflow.com/questions/13670692/403-forbidden-with-java-but-not-web-browser
        static final String AVOID_HTTP403_FORBIDDEN = "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11";


        /**
         * 云端响应头拦截器，用来配置缓存策略
         * Dangerous interceptor that rewrites the server's cache-control header.
         */
        private static final Interceptor sRewriteCacheControlInterceptor = new Interceptor() {

                @Override
                public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                       if (!NetworkUtils.isConnected()) {
                                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
                                Logger.e("no network");
                        }
                        Response originalResponse = chain.proceed(request);

                        if (NetworkUtils.isConnected()) {
                                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                                String cacheControl = request.cacheControl().toString();
                                return originalResponse.newBuilder()
                                        .header("Cache-Control", cacheControl)
                                        .removeHeader("Pragma")
                                        .build();
                        } else {
                                return originalResponse.newBuilder()
                                        .header("Cache-Control", "public, " + CACHE_CONTROL_CACHE)
                                        .removeHeader("Pragma")
                                        .build();
                        }
                }
        };



        /**
         * 打印返回的json数据拦截器
         */
        private static final Interceptor sLoggingInterceptor = new Interceptor() {

                @Override
                public Response intercept(Chain chain) throws IOException {
                        final Request request = chain.request();
                        Buffer requestBuffer = new Buffer();
                        if (request.body() != null) {
                                request.body().writeTo(requestBuffer);
                        } else {
                                Logger.d("LogTAG", "request.body() == null");
                        }
                        //打印url信息
                        Logger.w(request.url() + (request.body() != null ? "?" + _parseParams(request.body(), requestBuffer) : ""));
                        final Response response = chain.proceed(request);

                        return response;
                }
        };

        private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .addInterceptor(sLoggingInterceptor);
//                .addInterceptor(sRewriteCacheControlInterceptor);

        @NonNull
        private static String _parseParams(RequestBody body, Buffer requestBuffer) throws UnsupportedEncodingException {
                if (body.contentType() != null && !body.contentType().toString().contains("multipart")) {
                        return URLDecoder.decode(requestBuffer.readUtf8(), "UTF-8");
                }
                return "null";
        }

        private static Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        private static Retrofit retrofit = builder.client(httpClient.build()).build();

        public static <S> S createService(Class<S> serviceClass) {
            return retrofit.create(serviceClass);
        }




}
