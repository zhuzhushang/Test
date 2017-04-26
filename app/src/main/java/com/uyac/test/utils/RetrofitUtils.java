package com.uyac.test.utils;

import com.uyac.test.constants.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by noah on 2017/4/25.
 */

public class RetrofitUtils {



        private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        private static Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        private static Retrofit retrofit = builder.client(httpClient.build()).build();

        public static <S> S createService(Class<S> serviceClass) {
            return retrofit.create(serviceClass);
        }



}
