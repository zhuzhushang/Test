package com.uyac.test.activity;

import android.Manifest;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatSeekBar;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.format.Formatter;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RemoteViews;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.uyac.test.R;
import com.uyac.test.adapter.MyBaseAdapter;
import com.uyac.test.adapter.MyRecyclerAdapter;
import com.uyac.test.adapter.RecycleAdapter;
import com.uyac.test.constants.Constants;
import com.uyac.test.fragment.ButterKnifeFragment;
import com.uyac.test.interfaces.GetWeatherData;
import com.uyac.test.interfaces.LoginInfo;
import com.uyac.test.model.ImgShowModel;
import com.uyac.test.model.LoginModel;
import com.uyac.test.model.Model;
import com.uyac.test.model.SSQModel;
import com.uyac.test.model.TempModel;
import com.uyac.test.model.TestModel;
import com.uyac.test.model.WeatherModel;
import com.uyac.test.other.HanDict;
import com.uyac.test.receiver.MyReceiver;
import com.uyac.test.service.MusicService;
import com.uyac.test.service.MyIntentService;
import com.uyac.test.sqlite.MySqliteHelper;
import com.uyac.test.sqlite.SqliteModel;
import com.uyac.test.utils.CheckForAllUtils;
import com.uyac.test.utils.GsonUtils;
import com.uyac.test.utils.PreferencesUtils;
import com.uyac.test.utils.RetrofitUtils;
import com.uyac.test.utils.ToastUtils;
import com.uyac.test.widget.ChooseRetuanMoneyReasonPop;
import com.uyac.test.widget.CirCleProgressView;
import com.uyac.test.widget.CustomListView;
import com.uyac.test.widget.DynamicNumView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import cz.msebera.android.httpclient.Header;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.type;
import static android.text.Spanned.SPAN_INCLUSIVE_EXCLUSIVE;
import static android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE;
import static com.uyac.test.R.id.result;
import static com.uyac.test.R.mipmap.b;

public class MainActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener {

    private String TAG = "MainActivity";

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.confirm:

//                testED();
//                testCallPhone();
//                notifyc();
//                simpleNotify();
//                test_text.startNum();
//                onConfirmClick();
//                mySqliteHelper.addData2("yes",1,100,"南山大道112号");
//                onclickliu();
//                onSetPercent();
//                startActivity(new Intent(context,SensorActivity.class));
//                setAlarm();
//                testGlideLoadImage();
//                onOkHttpClick();
//                onOkHttpClickPost();
//                onOkHttpClickPostLogin();
//                testRetrofit();
//                testRetrofitOkhttp();
//                testRetrofitOkhttpGetWeatherData2();
//                changeHeight();
//                testIntentServiceOnClick();
//                testActivityAnimationClick();
//                testSimpleDialogOnClick();
//                testRetrofitOkhttpGetWeatherData2();
//                testActivityAnimationClick();
//                onTestRetrofitUtilsClick();
                testRxjavaOnClick();

                break;
            case R.id.confirm2:

                testRxjavaOnClick2();
                break;

            case R.id.heigth:


//                test();
//                testParse();
//                testNewIntentOnClick();
                crmrp.showAtLocation(numpicker, Gravity.CENTER, 0, 0);

                break;
//            case R.id.gesture_detector_tv:
//
//                ToastUtils.show(context,"单击");
//
//                break;
            case R.id.start:

                musicService.start();

                break;
            case R.id.pause:

                musicService.pause();
                break;
            case R.id.stop:

                musicService.stop();
                break;
            case R.id.notifycation:

                notification();

                break;
            case R.id.move_notifycation:

                moveNotification();

                break;
        }

    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        SuiBianView view = new SuiBianView(context);
//        CirCleProgressView cirCleProgressView = new CirCleProgressView(context);
//        PacManView pacManView = new PacManView(context);
//        setContentView(pacManView);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);

        init();
        test();

    }

    private void test() {
        //        testAsync();
//        testList();
//        test();
//        testText();
//        testText2();
//        testIntent();
//        testCheck();
//        testNewIntent();
//        testNumPicker();
//        testSeekbar();
//        testDash();
//        testH();
//        testTextSize();
//        testPreference();
//        testEdittext();
//        testHanZi();
//        testNullPoint();
//        testTextView();
//        testGestureDetector();
//        testGestureDetector2();
//        testSqlite();
//        testHeigth();
//        testTimePicker();
//        testCalendar();
//        testListView();
//        testRecyclerView();
//        testApplicationDialog();
//        testDate();
//        testSqlite();
//        testButterKnife();
//        testWeakReference();
//        testCircle();
//        testService();
//        testSensor();
//        testAlarm();
//        testNotification();
//        testGlide();
//        testOkHttp3();
//        testRetrofit2_2();
//        sortArray();
//        testTvArray();
//        testAnimation();
//        testIntentService();
//        testRecycler();
//        testScrollview();
//        testAppBarLayout();
//        testRetrofit2_2();
//        testActivityAnimation();
//        testActivityAnimation();
//        testSimpleDialog();
//        testRetrofitUtils();
        testRxjava();


    }

    private Observable<String> observableString;
    private Observable<List<String>> observableList;
    //冷的
    PublishSubject publishSubject ;


    /**
     * test rxjava
     */
    private void testRxjava() {

        findViewById(R.id.confirm).setOnClickListener(this);
        findViewById(R.id.confirm2).setOnClickListener(this);

        List<String> list = new ArrayList<>();
        list.add("zhang san");
        list.add("zhang san");
        list.add("zhang san");
        list.add("zhang san");
/*
        observableString = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@io.reactivex.annotations.NonNull ObservableEmitter<String> e) throws Exception {

                for (int i = 0; i < 5; i++) {

                    e.onNext("this is num "+i+" ");
                }

                e.onComplete();
            }
        });*/


//        observableList = Observable.from(list);
//        observableString = Observable.fromArray(list);
//        observableString = Observable.just("sds","sdfds","sdfgg");
//        observableString = Observable.empty();
//        observableString = Observable.never();
        publishSubject = publishSubject.create();


    }

    /**
     *rxjava 点击事件
     */
    private void testRxjavaOnClick()
    {

        publishSubject.subscribe(new Observer<String>(){
            @Override
            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

                Log.e(TAG, "onSubscribe: " );
            }

            @Override
            public void onNext(@io.reactivex.annotations.NonNull String s) {

                Log.e(TAG, "onNext: "+s );

            }

            @Override
            public void onError(@io.reactivex.annotations.NonNull Throwable e) {

                Log.e(TAG, "onError: " );
            }

            @Override
            public void onComplete() {

                Log.e(TAG, "onComplete: " );
            }
        });


/*        observableString.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

            }

            @Override
            public void onNext(@io.reactivex.annotations.NonNull String s) {

                Log.e("=====","---------->"+s);


            }

            @Override
            public void onError(@io.reactivex.annotations.NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

                Log.e(TAG, "onComplete: " );

            }
        });*/


/*        observableList.subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

            }

            @Override
            public void onNext(@io.reactivex.annotations.NonNull List<String> strings) {

            }

            @Override
            public void onError(@io.reactivex.annotations.NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });*/

/*        observableString.subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

            }

            @Override
            public void onNext(@io.reactivex.annotations.NonNull String s) {

                Log.e("=====","---------->"+s);


            }

            @Override
            public void onError(@io.reactivex.annotations.NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

                Log.e(TAG, "onComplete: " );

            }
        });*/



    }

    private void testRxjavaOnClick2()
    {

        publishSubject.onNext("你好吗");

    }





    private TextView tv_test_retrofit_utils;

    /**
     * 测试retrofit + rxjava
     */
    private void testRetrofitUtils() {

        findViewById(R.id.confirm).setOnClickListener(this);
//        tv_test_retrofit_utils = findViewById(R.id.tv_retrofit_utils);
        tv_test_retrofit_utils = (TextView) findViewById(R.id.tv_retrofit_utils);

    }

    /**
     * 测试retrofit + rxjava  点击事件
     */
    private void onTestRetrofitUtilsClick()
    {
        Map<String, String> fields = new HashMap<>();
        fields.put("app", "weather.future");
        fields.put("weaid", "1");
        fields.put("appkey", "10003");
        fields.put("sign", "b59bc3ef6191eb9f747dd4e83c99f2a4");
        fields.put("format", "json");
        GetWeatherData getWeatherData = RetrofitUtils.createService(GetWeatherData.class);
        Observable<WeatherModel> observable = getWeatherData.followers(fields);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WeatherModel>() {
                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull WeatherModel weatherModel) {

                        ToastUtils.show(context,weatherModel.getSuccess());
                        tv_test_retrofit_utils.setText(weatherModel.getSuccess()+ weatherModel.getResult().get(0).getWeather());

                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {

                        ToastUtils.show(context,"onError");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    /**
     * 只是测试一下系统的dialog
     */
    private void testSimpleDialog() {

        findViewById(R.id.confirm).setOnClickListener(this);

    }

    private void testSimpleDialogOnClick()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示").setCancelable(false).setMessage("你确定退出吗？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                ToastUtils.show(context,"点击了确定");
            }
        }).setNegativeButton("取消",null).show();

    }


    /**
     * 测试activity跳转动画
     */
    private void testActivityAnimation() {

        findViewById(R.id.confirm).setOnClickListener(this);

    }

    private void testActivityAnimationClick()
    {

        startActivity(TestActivity.class);

    }





    private void testRetrofit2_2() {

        confirm2 = (Button) findViewById(R.id.confirm);
        confirm2.setOnClickListener(this);
//        okhttp_tv = (TextView) findViewById(R.id.okhttp_tv);
        okhttp_tv = (TextView) findViewById(R.id.tv_retrofit_utils);

    }


    /**
     * retrofit请求  带okhttp  获取天气  上面一个有问题
     */
    private void testRetrofitOkhttpGetWeatherData2() {

        Map<String, String> fields = new HashMap<>();
        fields.put("app", "weather.future");
        fields.put("weaid", "1");
        fields.put("appkey", "10003");
        fields.put("sign", "b59bc3ef6191eb9f747dd4e83c99f2a4");
        fields.put("format", "json");

        OkHttpClient.Builder okhttpBuilder = new OkHttpClient.Builder();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl_okHttp)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = retrofitBuilder.client(okhttpBuilder.build()).build();
        GetWeatherData getWeatherData = retrofit.create(GetWeatherData.class);
        retrofit2.Call<WeatherModel> weatherModelCall = getWeatherData.getWeather(fields);
        weatherModelCall.enqueue(new retrofit2.Callback<WeatherModel>() {
            @Override
            public void onResponse(retrofit2.Call<WeatherModel> call, retrofit2.Response<WeatherModel> response) {

                ToastUtils.show(context, response.message());
                okhttp_tv.setText("Code = " + response.body().getSuccess() + "\n"
                        + "server = " + response.body().getResult().get(0).getWeek() + "\n"
                        + "msg = " + response.body().getResult().get(0).getWeather() + "\n");

            }

            @Override
            public void onFailure(retrofit2.Call<WeatherModel> call, Throwable t) {

                ToastUtils.show(context, "获取失败");
            }
        });
    }


    private Toolbar toolbar;

    private void testAppBarLayout() {

        toolbar = (Toolbar) findViewById(R.id.toolbar);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(ContextCompat.getDrawable(context,R.mipmap.arrow_back_48px_));

        toolbar.setNavigationIcon(R.mipmap.arrow_back_48px_);
        toolbar.setTitle("");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ToastUtils.show(context,v.getId()+"");
            }
        });
//        setSupportActionBar(toolbar);

    }

    private TextView scroll_tv;

    private void testScrollview() {


        scroll_tv = (TextView) findViewById(R.id.scroll_tv);

        scroll_tv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction())
                {
                    case MotionEvent.ACTION_MOVE:


                        Log.e(TAG, "onTouch:  x = "+event.getX()+"   y = "+event.getY() );
//                        scroll_tv.setY(event.getY());


                        break;
                }

                return true;
            }
        });
    }


    private RecyclerView recyclerViewTest;
    private MyRecyclerAdapter mTestAdapter;
    private List<TempModel> mTestList;
    private SwipeRefreshLayout swipeRefreshLayout;

    private void testRecycler() {

        mTestList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {

            mTestList.add(new TempModel("这是第"+(i+1)+"个"));
        }

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.black,R.color.blue,R.color.red);
        swipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        recyclerViewTest = (RecyclerView) findViewById(R.id.recyclerview_test );
        mTestAdapter = new MyRecyclerAdapter(context,mTestList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recyclerViewTest.setLayoutManager(linearLayoutManager);
        recyclerViewTest.setAdapter(mTestAdapter);

        recyclerViewTest.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                LinearLayoutManager llm = (LinearLayoutManager) recyclerViewTest.getLayoutManager();
                int lastVisibleItem = llm.findLastVisibleItemPosition();
                int totalItem = recyclerView.getAdapter().getItemCount();
                int visibleCount = recyclerView.getChildCount();

                if(newState == RecyclerView.SCROLL_STATE_IDLE && totalItem - 1 == lastVisibleItem && visibleCount > 0)
                {

                    ToastUtils.show(context,"滑动到底部了");
                }

            }
        });


    }

    private SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

//            swipeRefreshLayout.setEnabled(false);
//            if(!swipeRefreshLayout.isRefreshing())
//            {

//                swipeRefreshLayout.setRefreshing(true);
                new MyAsyncTask().execute("nihao");
//            }


        }
    };

    public class MyAsyncTask extends AsyncTask<String ,Void,String>
    {
        @Override
        protected String doInBackground(String... params) {

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return params[0];
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            ToastUtils.show(context,s);
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    /**
     * 测试Intentservice
     */
    private void testIntentService() {

        findViewById(R.id.confirm).setOnClickListener(this);

    }

    private void testIntentServiceOnClick() {

        Intent intent = new Intent(context, MyIntentService.class);
        intent.putExtra("123","456");
        startService(intent);

//        ToastUtils.show(context,"启动服务成功");
        Log.e(TAG, "testIntentServiceOnClick: ");
    }

    private TextView tvArrayTv[];
    private int tvArrayTvID[] = {R.id.test_arry_textview1, R.id.test_arry_textview2, R.id.test_arry_textview3, R.id.test_arry_textview4, R.id.test_arry_textview5};

    private TextView animation_tv;
    private ValueAnimator valueAnimator;

    /**
     * 测试改变view的高
     * <p>
     * 让高度慢慢变为0
     */
    private void testAnimation() {


        findViewById(R.id.confirm).setOnClickListener(this);
        animation_tv = (TextView) findViewById(R.id.animation_tv);

        valueAnimator = ValueAnimator.ofFloat(1, 0);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

//               Float f = (Float) animation.getAnimatedValue();
//                ViewGroup.LayoutParams layoutParams = animation_tv.getLayoutParams();
//                layoutParams.width = layoutParams

                Float f = (Float) animation.getAnimatedValue();
                animation_tv.setPivotY(0f);
                animation_tv.setScaleY(f);

            }
        });


    }

    private void changeHeight() {

        valueAnimator.start();

    }


    View.OnClickListener testOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            for (int i = 0; i < tvArrayTvID.length; i++) {

                if (v == tvArrayTv[i]) {
                    ToastUtils.show(context, "zheshidi " + (i + 1) + " ge");
                }

            }

        }
    };


    private int array[] = {234, 325, 41, 63, 56, 87, 8, 78, 777, 87, 89, 8, 989, 324, 23};

    /**
     * 冒泡排序
     */
    private void sortArray() {

        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < array.length - 1 - i; j++) {

                if (array[i] > array[j + 1]) {
                    int temp = array[i];
                    array[i] = array[j + 1];
                    array[j + 1] = temp;
                }

            }
        }


        for (int i = 0; i < array.length; i++) {

        }

    }





    /**
     * retrofit请求  带okhttp  获取天气
     */
    private void testRetrofitOkhttpGetWeatherData() {
        OkHttpClient.Builder httpClientBuild = new OkHttpClient.Builder();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(baseUrl_okHttp)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = retrofitBuilder.client(httpClientBuild.build()).build();
        LoginInfo loginInfo = retrofit.create(LoginInfo.class);

        Map<String, String> fields = new HashMap<>();
        fields.put("app", "weather.future");
        fields.put("weaid", "1");
        fields.put("appkey", "10003");
        fields.put("sign", "b59bc3ef6191eb9f747dd4e83c99f2a4");
        fields.put("format", "json");

        retrofit2.Call<LoginModel> call = loginInfo.getLoginInfo(fields);
        call.enqueue(new retrofit2.Callback<LoginModel>() {
            @Override
            public void onResponse(retrofit2.Call<LoginModel> call, retrofit2.Response<LoginModel> response) {

                ToastUtils.show(context, response.body().getMsg());
                okhttp_tv.setText("Code = " + response.body().getCode() + "\n"
                        + "server = " + response.body().getServer() + "\n"
                        + "msg = " + response.body().getMsg() + "\n");
            }

            @Override
            public void onFailure(retrofit2.Call<LoginModel> call, Throwable t) {

                ToastUtils.show(context, "获取失败");

            }
        });

    }

    /**
     * retrofit请求  带okhttp
     */
    private void testRetrofitOkhttp() {
        OkHttpClient.Builder httpClientBuild = new OkHttpClient.Builder();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Constants._url_api_formal)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = retrofitBuilder.client(httpClientBuild.build()).build();
        LoginInfo loginInfo = retrofit.create(LoginInfo.class);

        Map<String, String> fields = new HashMap<>();
        fields.put("_apiname", "Login.login");
        fields.put("f_username", "13823214300");
        fields.put("f_userpwd", "123456");

        retrofit2.Call<LoginModel> call = loginInfo.getLoginInfo(fields);
        call.enqueue(new retrofit2.Callback<LoginModel>() {
            @Override
            public void onResponse(retrofit2.Call<LoginModel> call, retrofit2.Response<LoginModel> response) {

                ToastUtils.show(context, response.body().getMsg());
            }

            @Override
            public void onFailure(retrofit2.Call<LoginModel> call, Throwable t) {

                ToastUtils.show(context, "获取失败");

            }
        });

    }


    /**
     * retrofit请求  没利用okhttp
     */
    private void testRetrofit() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants._url_api_formal)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Map<String, String> fields = new HashMap<>();
        fields.put("_apiname", "Login.login");
        fields.put("f_username", "13823214300");
        fields.put("f_userpwd", "123456");

        LoginInfo loginInfo = retrofit.create(LoginInfo.class);
        retrofit2.Call<LoginModel> call = loginInfo.getLoginInfo(fields);
        call.enqueue(new retrofit2.Callback<LoginModel>() {
            @Override
            public void onResponse(retrofit2.Call<LoginModel> call, retrofit2.Response<LoginModel> response) {

                ToastUtils.show(context, "成功" + response.body().getMsg());
            }

            @Override
            public void onFailure(retrofit2.Call<LoginModel> call, Throwable t) {

                ToastUtils.show(context, "获取失败");

            }
        });

    }


    private TextView okhttp_tv;
    private Button confirm2;
    private OkHttpClient okHttpClient;
    private Handler handler;

    private String okhttp_url = "http://api.k780.com:88/?app=weather.future&weaid=1&&appkey=10003&sign=b59bc3ef6191eb9f747dd4e83c99f2a4&format=json";
    private String baseUrl_okHttp = "http://api.k780.com:88/";

    /**
     * 测试okhttp
     */
    private void testOkHttp3() {

        confirm2 = (Button) findViewById(R.id.confirm);
        okhttp_tv = (TextView) findViewById(R.id.okhttp_tv);
        confirm2.setOnClickListener(this);
        handler = new MyHandler(MainActivity.this);
        okHttpClient = new OkHttpClient();

    }

    /**
     * okhttp get 调用
     */
    private void onOkHttpClick() {

        Request.Builder builder = new Request.Builder().url(okhttp_url).method("GET", null);
        Request request = builder.build();
        Call mCall = okHttpClient.newCall(request);
        mCall.enqueue(new MyCallback());

    }

    /**
     * get 调用获取天气
     */
    private void onOkHttpClickPost() {
        RequestBody requestBody = new FormBody.Builder()
                .add("app", "weather.future")
                .add("weaid", "1")
                .add("appkey", "10003")
                .add("sign", "b59bc3ef6191eb9f747dd4e83c99f2a4")
                .add("format", "json").build();

        Request.Builder builder = new Request.Builder().url(baseUrl_okHttp).post(requestBody);
        Request request = builder.build();
        Call mCall = okHttpClient.newCall(request);
        mCall.enqueue(new MyCallback());

    }

    private void onOkHttpClickPostLogin() {
        RequestBody requestBody = new FormBody.Builder()
                .add("_apiname", "Login.login")
                .add("f_username", "13823214300")
                .add("f_userpwd", "123456").build();

        Request.Builder builder = new Request.Builder().url(Constants._url_api_formal).post(requestBody);
        Request request = builder.build();
        Call mCall = okHttpClient.newCall(request);
        mCall.enqueue(new MyCallback());

    }

    /**
     * okhtt回调
     */
    private class MyCallback implements Callback {
        @Override
        public void onFailure(Call call, IOException e) {

            handler.sendEmptyMessage(OKHTTP_FAIL);

        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {


            Message message = Message.obtain();
            message.obj = response.body().string();
            message.what = OKHTTP_SUCCESS;
            handler.sendMessage(message);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    ToastUtils.show(context, "请求成功");

                }
            });


        }
    }


    /*
    * 我的handler
    * */
    public class MyHandler extends Handler {
        WeakReference<Activity> weakReference;

        public MyHandler(Activity activity) {
            weakReference = new WeakReference<Activity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case OKHTTP_FAIL:

                    ToastUtils.show(context, "获取数据失败");
                    break;
                case OKHTTP_SUCCESS:
                    Log.e(TAG, "onResponse:    " + (String) (msg.obj));
                    okhttp_tv.setText("" + (String) (msg.obj));

                    break;
            }
        }
    }

    private final int OKHTTP_FAIL = 0x1001;
    private final int OKHTTP_SUCCESS = 0x1002;


    private Button confirm;
    private ImageView glide_image;
    private String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b10000_10000&sec=1490069283&di=a5353db2be34f3e40115e5ee2176eb10&src=http://imgsrc.baidu.com/forum/pic/item/55e736d12f2eb9387dccd260d5628535e4dd6ffb.jpg";
    private String url2 = "sdafjsal;fj;sajf;das";

    /**
     * 测试glide
     */
    private void testGlide() {

        confirm = (Button) findViewById(R.id.confirm);
        glide_image = (ImageView) findViewById(R.id.glide_image);

        confirm.setOnClickListener(this);

    }


    /**
     * 点击调用方法 测试glide
     */
    private void testGlideLoadImage() {

        Glide.with(this).load(url2).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(R.mipmap.ic_launcher).error(R.mipmap.b).into(glide_image);

    }


    private NotificationManager nManager;
    private Button notifycation, move_notifycation;

    /**
     * notifycation
     */
    private void testNotification() {

        nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notifycation = (Button) findViewById(R.id.notifycation);
        notifycation.setOnClickListener(this);
        move_notifycation = (Button) findViewById(R.id.move_notifycation);
        move_notifycation.setOnClickListener(this);

        notifycation.setText("" + Calendar.getInstance().getTimeInMillis());
        move_notifycation.setText("" + System.currentTimeMillis());
    }


    private void notification() {
        //使用V7中的NotifycationCompat 兼容性更加好
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("title");
        builder.setContentText("content_text");
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_yaxun_jingpin_collect));
        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setSmallIcon(R.mipmap.star);
        builder.setTicker("you have a message,");
        Notification notification = builder.build();
        nManager.notify(R.mipmap.star, notification);

    }

    private void moveNotification() {

        nManager.cancel(R.mipmap.star);
    }


    private AlarmManager alarmManager;

    private void testAlarm() {

        Thread e = new Thread();

        findViewById(R.id.confirm).setOnClickListener(this);
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

    }

    /**
     * naozhong
     */
    private void setAlarm() {

        //设置一个广播intent，时间到时，这个receiver会收到广播。
        Intent intent = new Intent(MainActivity.this, MyReceiver.class);
        //设置pendingIntent 打开一个广播
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        //设置闹钟开始时间
        long startTime = System.currentTimeMillis() + 1000 * 10;
        //大于19可以使用setWindow和setExact 更加精确
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //此方法第3个参数不知道啥意思
//            alarmManager.setWindow(AlarmManager.RTC_WAKEUP, startTime, 0, pendingIntent);
            //这两个方法，测试了下，其实也不那么精确
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, startTime, pendingIntent);
        } else {
            //设置一次性闹钟
//            alarmManager.set(AlarmManager.RTC_WAKEUP, startTime, pendingIntent);
            //设置重复闹钟 第3个参数代表重复时间（第二次闹钟时间），这里为1分钟
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, startTime, 1000 * 60, pendingIntent);
            //取消闹钟
//            alarmManager.cancel(pendingIntent);

        }

        Toast.makeText(context, "设置闹钟成功", Toast.LENGTH_SHORT).show();

    }

    private SensorManager sensorManager;

    private void testSensor() {

        findViewById(R.id.confirm).setOnClickListener(this);
        Toast.makeText(MainActivity.this, "fff", Toast.LENGTH_SHORT).show();

    }

    private MusicService musicService;

    private void testService() {

        Intent intent = new Intent(getApplicationContext(), MusicService.class);
        bindService(intent, sc, Service.BIND_AUTO_CREATE);
        findViewById(R.id.start).setOnClickListener(this);
        findViewById(R.id.pause).setOnClickListener(this);
        findViewById(R.id.stop).setOnClickListener(this);

    }


    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            musicService = ((MusicService.MyBinder) service).getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            musicService = null;
        }
    };


    private CirCleProgressView mCirCleProgressView;
    private Button btn;

    private void testCircle() {

        btn = (Button) findViewById(R.id.confirm);
        mCirCleProgressView = (CirCleProgressView) findViewById(R.id.percent);
        btn.setOnClickListener(this);

    }

    private void onSetPercent() {

        int p = mCirCleProgressView.getPercent();
        int plus = mRandom.nextInt(10);
        mCirCleProgressView.setPercent(p + plus);

    }


    private WeakReference<Model> mWeak;

    private void testWeakReference() {

        Model model = new Model();
        mWeak = new WeakReference<Model>(model);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    //    @BindView(R.id.textView3)
//    TextView textView3;

//    @BindView(R.id.linear)
//    LinearLayout linear;

    private void testButterKnife() {

//        textView3.setText("这是bufferknife");
        ButterKnifeFragment fragment = new ButterKnifeFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.linear, fragment).commit();

    }

/*    @OnClick({R.id.confirm, R.id.textView2})
    public void onMyClick(View view)
    {
        switch(view.getId())
        {
            case R.id.confirm:
                ToastUtils.show(context,"confirm");
                break;
            case textView3:
                ToastUtils.show(context,"textView");
                break;
            case R.id.textView2:
                ToastUtils.show(context,"textView2");

                break;
        }
    }*/


    private MySqliteHelper mySqliteHelper;

    private void testSqlite() {

        mySqliteHelper = new MySqliteHelper(context, "WO", null, 3);
        findViewById(R.id.confirm).setOnClickListener(this);

        SqliteModel model = new SqliteModel();
        model.setAge(10);
        model.setName("jiushi");
        model.setSex(1);
//        mySqliteHelper.addData("jiushi",0,10);
//        mySqliteHelper.addData2("yes",1,100,"南山大道112号");
//        mySqliteHelper.addData2("yes",0,56,"南山大道100号");
//        mySqliteHelper.deleteAllData();

//        SqliteModel model = new SqliteModel();
//        model.setAge(10);
//        model.setName("jiushi");
//        model.setSex(1);
////        mySqliteHelper.addData("jiushi",0,10);
//        mySqliteHelper.addData2("yes",1,100,"南山大道112号");
//        mySqliteHelper.addData2("yes",0,56,"南山大道100号");
//
//
//        SqliteModel model1 = mySqliteHelper.queryIdData(1);
//
//        ToastUtils.show(context,model1.getName());

    }

    private void onclickliu() {

        startActivity(new Intent(context, TestActivity.class));

    }


    private void testDate() {

        findViewById(R.id.confirm).setOnClickListener(this);

    }

    private void onConfirmClick() {

        Calendar c = Calendar.getInstance();
        // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
        new DatePickerDialog(MainActivity.this,
                // 绑定监听器
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
//                        TextView show = (TextView) findViewById(R.id.txt1);
//                        show.setText("您选择了：" + year + "年" + monthOfYear
//                                + "月" + dayOfMonth + "日");

                        ToastUtils.show(context, "您选择了：" + year + "年" + monthOfYear
                                + "月" + dayOfMonth + "日");
                    }
                }
                // 设置初始日期
                , c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
                .get(Calendar.DAY_OF_MONTH)).show();
    }


    @Override
    public void onDetachedFromWindow() {

//        this.mAction


        super.onDetachedFromWindow();
    }

    private void testApplicationDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setTitle("你好");
        builder.setMessage("怎么样了");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();

            }
        });
        builder.show();

    }


    private RecyclerView recyclerView;
    private RecycleAdapter mAdapter;
    private List<ImgShowModel> mList;

    private void testRecyclerView() {

        mList = new ArrayList<>();

        for (int i = 0; i < 45; i++) {

            ImgShowModel model = new ImgShowModel();
            model.setDate("2016年3月" + (i + 1) + "日");
            model.setViewType(com.uyac.test.constants.Constants.ITEM_RECYCLER_DATE);
            mList.add(model);

            int itemNum = randomNum(1, 4);
            for (int j = 0; j < itemNum; j++) {

                ImgShowModel imgModel = new ImgShowModel();
                imgModel.setViewType(Constants.ITEM_RECYCLER_IMG);
                int imgData[] = null;
                if (j == itemNum - 1) {
                    //最后一个不满7条数据的情况
                    imgData = new int[randomNum(1, 7)];
                } else {
                    imgData = new int[7];
                }
                for (int k = 0; k < imgData.length; k++) {

//                    imgData[k] = imgArray[mRandom.nextInt(imgArray.length)];
                    imgData[k] = R.mipmap.ic_launcher;
                }

                imgModel.setImg(imgData);
                mList.add(imgModel);

            }
        }

        mAdapter = new RecycleAdapter(this, mList);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 7, GridLayoutManager.VERTICAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(7,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

    }


    private int imgArray[] = {R.mipmap.b, R.mipmap.ic_launcher, R.mipmap.ic_yaxun_jingpin_collect, R.mipmap.star, R.mipmap.test_ic_launch};


    /**
     * @param min
     * @param max
     * @return 随机几到几
     */
    private int randomNum(int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }


        int r = Math.abs(max - min) + 1;

        return mRandom.nextInt(r) + min;
    }


    private CustomListView listview;
    private MyBaseAdapter mAdapter1;
    private List<TestModel> mList1;

    private void testListView() {

        listview = (CustomListView) findViewById(R.id.listview);
        mList1 = new ArrayList<>();
        mAdapter1 = new MyBaseAdapter(context, mList1, R.layout.item_test);

        for (int i = 0; i < 100; i++) {

            mList1.add(new TestModel("好的"));
        }

        listview.setAdapter(mAdapter1);


    }

    private void testCalendar() {

    }


    @Override
    protected void onResume() {
        super.onResume();

//        int heigth = custom_heigth.getHeight();
//        custom_heigth.setHeight(heigth * 2);

//        LinearLayout.LayoutParams lin = (LinearLayout.LayoutParams) custom_heigth.getLayoutParams();
//        lin.height = 200;
//        custom_heigth.setLayoutParams(lin);
//
//        Calendar calendar = Calendar.getInstance();
//        int dow = calendar.get(Calendar.DAY_OF_WEEK);
//
//        custom_heigth.setText(""+dow);

    }

    private TextView custom_heigth;

    private void testHeigth() {

        findViewById(R.id.confirm).setOnClickListener(this);
        custom_heigth = (TextView) findViewById(R.id.custom_heigth);


    }

    //        testCourseTableHomePager();
//        testCustomView();
//        testEdit();


    private GestureDetector mGestureDetector2;
    private final int MIN_DISTANCE = 100;
    private final int MIN_SPEED = 200;


    private void testGestureDetector2() {

        MyGestureDetector2 myGestureDetector = new MyGestureDetector2();
        mGestureDetector2 = new GestureDetector(this, myGestureDetector);
//        gesture_detector_tv = (TextView) findViewById(R.id.gesture_detector_tv);
        gesture_detector_tv.setOnTouchListener(this);
        gesture_detector_tv.setClickable(true);
        gesture_detector_tv.setFocusable(true);
        gesture_detector_tv.setLongClickable(true);

    }


    public class MyGestureDetector2 extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            Log.e("MyGestureDetector2", "onFling" + "\n  e1_x = " + e1.getY() + "\n" +
                    "  e2_x = " + e2.getX() + "\n" + "  distans = " + Math.abs(e2.getX() - e1.getX()) + "\n" +
                    "  velocityX = " + velocityX + "\n" +
                    "  velocity = " + velocityY);

            if (e1.getX() - e2.getX() > MIN_DISTANCE && Math.abs(velocityX) > MIN_SPEED) {

                ToastUtils.show(context, "左滑");
            }


            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {


            ToastUtils.show(context, "点击");

            return true;
        }
    }


    private GestureDetector mGestureDetector;
    private TextView gesture_detector_tv;


    private void testGestureDetector() {
        MyGestureDetector myGestureDetector = new MyGestureDetector();
        mGestureDetector = new GestureDetector(this, myGestureDetector);
        mGestureDetector.setOnDoubleTapListener(myGestureDetector);
//        gesture_detector_tv = (TextView) findViewById(R.id.gesture_detector_tv);
        gesture_detector_tv.setOnTouchListener(this);
        gesture_detector_tv.setClickable(true);
        gesture_detector_tv.setFocusable(true);
        gesture_detector_tv.setLongClickable(true);

        gesture_detector_tv.setOnClickListener(this);


    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {


        return mGestureDetector2.onTouchEvent(event);
    }


    private class MyGestureDetector implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {


        /**
         * 按下就触发
         */
        @Override
        public boolean onDown(MotionEvent e) {

            Log.e("MyGestureDetector :", "onDown");
            ToastUtils.show(context, "onDown");
            return true;
        }

        /**
         * 超过瞬间就会触发（）
         */
        @Override
        public void onShowPress(MotionEvent e) {

            Log.e("MyGestureDetector :", "onShowPress");
            ToastUtils.show(context, "onShowPress");

        }

        /**
         * 轻击屏幕
         * <p>
         * 点击非常快的
         * onDown  --> onSingleTapUp  -->  onSingleTapComfirmed
         * <p>
         * 点击一下稍微慢点的
         * onDown  -->  onShowPress  -->  onSingleTapUp  --> onSingleTapComfirmed
         */
        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.e("MyGestureDetector :", "onSingleTapUp");
            ToastUtils.show(context, "onSingleTapUp");

            return false;
        }

        /**
         * @param e1
         * @param e2
         * @param distanceX x轴上移动的速度   像素/s
         * @param distanceY y轴上的移动速度   像素/s
         *                  <p>
         *                  滑动的时候执行（手还在view上）
         *                  <p>
         *                  onDown -->  onShowPress  -->
         */
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            Log.e("MyGestureDetector :", "onScroll");
            ToastUtils.show(context, "onScroll");

            return true;
        }

        /**
         * 长按
         * <p>
         * ondown  -->  onShowPress  --> onLongPress
         */
        @Override
        public void onLongPress(MotionEvent e) {
            Log.e("MyGestureDetector :", "onLongPress");
            ToastUtils.show(context, "onLongPress");

        }

        /**
         * @param e1
         * @param e2
         * @param velocityX x轴上移动的速度  像素/.s
         * @param velocityY y轴上的移动速度  像素/s
         * @return
         */
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.e("MyGestureDetector :", "onFling");
            ToastUtils.show(context, "onFling");

            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {


            Log.e("MyGestureDetector :", "onSingleTapConfirmed");
            ToastUtils.show(context, "onSingleTapConfirmed");

            return false;
        }

        /**
         * @param e
         * @return 双击   执行完这个方法之后 会执行onDown方法，然后执行onDoubleTapEvent
         */
        @Override
        public boolean onDoubleTap(MotionEvent e) {

            Log.e("MyGestureDetector :", "onDoubleTap");
            ToastUtils.show(context, "onDoubleTap");
            return false;
        }

        /**
         * 双击之后执行，相应了onDoubleTap() --> onDown  -->  onDoubleTapEvent方法之后就会执行
         */
        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {

            Log.e("MyGestureDetector :", "onDoubleTapEvent");
            ToastUtils.show(context, "onDoubleTapEvent");
            return false;
        }
    }


    private void testTextView() {


    }

    private TextView view;

    private void testNullPoint() {

        try {

            tv.setText("-----");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void testHanZi() {

        char ch = '威';
        System.out.println(ch + "的拼音（中式注音）为：" + HanDict.getInstance(context).getPY(ch, true));
        System.out.println(ch + "的拼音（英式注音）为：" + HanDict.getInstance(context).getPY(ch, false));
        System.out.println(ch + "的部首为　　　　　　：" + HanDict.getInstance(context).getBS(ch));
        System.out.println(ch + "的部首笔画为　　　　：" + HanDict.getInstance(context).getBH(HanDict.getInstance(context).getBS(ch)));
        System.out.println(ch + "的笔画顺序为　　　　：" + HanDict.getInstance(context).getBH(ch));
        System.out.println(ch + "的笔画数为　　　　　：" + HanDict.getInstance(context).getBH(ch).length());
        System.out.println();


    }


    private EditText et_reply_comment;

    private void testEdittext() {

//        et_reply_comment = (EditText) findViewById(R.id.et_reply_comment);
        et_reply_comment.setImeOptions(EditorInfo.IME_ACTION_SEND);
        et_reply_comment.addTextChangedListener(mTextWatcher);

    }

    private final TextWatcher mTextWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        public void afterTextChanged(Editable s) {
            if (s.length() > 0) {
                int pos = s.length() - 1;

                if (s.toString().getBytes().length > 10) {
                    s.delete(pos, pos + 1);
                }
            }
        }
    };


    private DynamicNumView test_text;
    private TextView tv_confirm;


    Camera camera;
    Camera.Parameters parameters;

    private void testCustomView() {

        test_text = (DynamicNumView) findViewById(R.id.test_text);
        tv_confirm = (TextView) findViewById(R.id.confirm);
        tv_confirm.setOnClickListener(this);
//        tv_confirm.setText(""+getMemoryE);


        camera = Camera.open(0);
        if (camera != null) {
            tv_confirm.setText("不为空");
        }
//        parameters.getSupportedVideoHighFrameRateModes();
//        parameters.getSupportedVideoSizes();
    }

    private void testCourseTableHomePager() {

        findViewById(R.id.confirm).setOnClickListener(this);

    }

    private void notifyc() {
        manger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification.Builder builder = new Notification.Builder(context);
        RemoteViews myNotificationView = new RemoteViews(context.getPackageName(), R.layout.notification_view);
        myNotificationView.setTextViewText(R.id.notification_title, "11111111");
        myNotificationView.setTextViewText(R.id.notification_text, "22222");
//        myNotificationView.setImageViewBitmap(R.id.notification_large_icon, getLargeIcon(context, msg));
        myNotificationView.setImageViewResource(R.id.notification_small_icon, R.mipmap.ic_launcher);
        builder.setContent(myNotificationView)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("ticker")
                .setAutoCancel(true);

        ;
        manger.notify(1, builder.getNotification());
    }


    public static final int TYPE_Normal = 1;
    public static final int TYPE_Progress = 2;
    public static final int TYPE_BigText = 3;
    public static final int TYPE_Inbox = 4;
    public static final int TYPE_BigPicture = 5;
    public static final int TYPE_Hangup = 6;
    public static final int TYPE_Media = 7;
    public static final int TYPE_Customer = 8;
    private NotificationManager manger;

    private void simpleNotify() {

        manger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //为了版本兼容  选择V7包下的NotificationCompat进行构造
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        //Ticker是状态栏显示的提示
        builder.setTicker("简单Notification");
        //第一行内容  通常作为通知栏标题
        builder.setContentTitle("标题");
        //第二行内容 通常是通知正文
        builder.setContentText("通知内容");
        //第三行内容 通常是内容摘要什么的 在低版本机器上不一定显示
        builder.setSubText("这里显示的是通知第三行内容！");
        //ContentInfo 在通知的右侧 时间的下面 用来展示一些其他信息
        //builder.setContentInfo("2");
        //number设计用来显示同种通知的数量和ContentInfo的位置一样，如果设置了ContentInfo则number会被隐藏
        builder.setNumber(2);
        //可以点击通知栏的删除按钮删除
        builder.setAutoCancel(true);
        //系统状态栏显示的小图标
        builder.setSmallIcon(R.mipmap.ic_launcher);
        //下拉显示的大图标
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        Intent intent = new Intent(this, TestActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 1, intent, 0);
        //点击跳转的intent
        builder.setContentIntent(pIntent);
        //通知默认的声音 震动 呼吸灯
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification notification = builder.build();
        manger.notify(TYPE_Normal, notification);
    }


    private TextView tv;

    private void testPreference() {

        PreferencesUtils.putInt(context, null, 1);


        int value = PreferencesUtils.getInt(context, null, -1);

        Log.e("-----", "1111111111" + value);


        tv.setText("----");


    }


    //============定义初始化变量============================================
    private Random mRandom;


    /**
     * 做一些初始化的准备工作-
     */
    private void init() {

        getWritePermission();
        mRandom = new Random();

    }


    /**
     * 请求读写权限
     */
    private void getWritePermission() {
        if (PermissionChecker.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= 23) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSIONS_WRITE_EXTERNAL_STORAGE);
            }
        }
    }


    private final int REQUEST_PERMISSIONS_WRITE_EXTERNAL_STORAGE = 0x1001;


    private TextView testsize;
    private TextView testsize_typeview;
    private TextView testsize_dip2px;

    private void testTextSize() {

        testsize = (TextView) findViewById(R.id.testsize);
        testsize_typeview = (TextView) findViewById(R.id.testsize_typeview);
        testsize_dip2px = (TextView) findViewById(R.id.testsize_dip2px);

        testsize.setTextSize(getResources().getDimensionPixelOffset(R.dimen.textsize));
        testsize_typeview.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
        testsize_dip2px.setTextSize(dip2px(context, 15));

    }


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    private void testH() {

        findViewById(R.id.confirm).setOnClickListener(this);
    }

    private void testCallPhone() {

        if (Build.VERSION.SDK_INT >= 23) {

            //判断有没有拨打电话权限
            if (PermissionChecker.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                //请求拨打电话权限
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CODE);

            } else {
                callPhone("13823214321");
            }

        } else {
            callPhone("13823214321");
        }
    }


    /**
     * 请求权限的回调方法
     *
     * @param requestCode  请求码
     * @param permissions  请求的权限
     * @param grantResults 权限的结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE && PermissionChecker.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            ToastUtils.show(context, "授权成功");
            callPhone("13823214321");
        }

        if (requestCode == REQUEST_PERMISSIONS_WRITE_EXTERNAL_STORAGE && PermissionChecker.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            ToastUtils.show(context, "授权成功");
        }

    }

    @Override
    public boolean shouldShowRequestPermissionRationale(String permission) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("提示").setMessage("告诉用户为什么需要这个权限").setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        }).show();

        return true;
    }

    private void callPhone(String phoneNum) {
        //直接拨号
        Uri uri = Uri.parse("tel:" + phoneNum);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        //此处不判断就会报错
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {

            startActivity(intent);
        }
    }

    private final int REQUEST_CODE = 0x1001;

    private void callPhone1(String phoneNum) {
        //直接拨号
        /*Uri uri = Uri.parse("tel:13823214321");
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        startActivity(intent);*/

    }


    private void callUI() {
        //跳转到拨打电话界面
        Uri uri = Uri.parse("tel:13876543210");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

    private AppCompatEditText edittext_nickname;
    private String beforeText;
    private boolean isReset = true;


    private void testEdit() {

        edittext_nickname = (AppCompatEditText) findViewById(R.id.edittext_nickname);


    }

    private void testED() {

        String ets = edittext_nickname.getText().toString();

        int chineseCount = 0;
        int otherCount = 0;

        if (ets == null || ets.equals("")) {
            return;

        }

        if (ets.getBytes().length > 30) {
            ToastUtils.show(context, "输入超限");
//            edittext_nickname.setText(beforeText);
//            edittext_nickname.setSelection(edittext_nickname.length() - 1);
//            isReset = false;
            return;
        }

        for (int i = 0; i < ets.length(); i++) {

            char c = ets.charAt(i);

            if (c == 95 || c >= 97 && c <= 122 || c >= 48 && c <= 57 || c >= 65 && c <= 90) {

                otherCount++;

            } else if (c >= 19968 && c <= 40869) {
                chineseCount++;

            } else {
                ToastUtils.show(context, "仅支持中文、字母、下划线");
//                edittext_nickname.setText(beforeText);
//                edittext_nickname.setSelection(edittext_nickname.length() - 1);
//                isReset = false;
                return;
            }
        }
    }


    private void testDash() {


    }

    private AppCompatSeekBar mSeekbar;
    private AppCompatTextView seekbar_value;

    private void testSeekbar() {

        seekbar_value = (AppCompatTextView) findViewById(R.id.seekbar_value);
        mSeekbar = (AppCompatSeekBar) findViewById(R.id.seekbar);
        mSeekbar.setMax(15);
        tvOffset = getResources().getDimensionPixelOffset(R.dimen.welfare_offset);
        mSeekbar.setOnSeekBarChangeListener(this);


    }

    private float tvOffset;

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

//        int position=mSeekbar.getProgress();
//        float seek_width=  mSeekbar.getWidth() - getResources().getDimensionPixelOffset(R.dimen.welfare_margin);
//        float seek_x=mSeekbar.getX();
//        float y=mSeekbar.getY();
//        float width=(position * seek_width)/14 +seek_x +seekbar_value.getWidth();
//
//        seekbar_value.setText(position+"");
//        Log.e("------->应到位置",""+ (seek_width/14*position) + seek_x);
//        Log.e("------->实到位置",""+width);
//        Log.i("---------->width", seek_width+"");
//        Log.e("------>","tv_x = "+seekbar_value.getX()+"");
//        Log.e("------>","seek_x = "+seekbar_value.getX()+"");
//        Log.i("坐标---y", y+"");

        Rect thumbRect = seekBar.getThumb().getBounds();
        if (thumbRect != null) {

            Log.e("------", "left = " + thumbRect.left + "\n" + "top = " + thumbRect.top + "\n" + "right = " + thumbRect.right + "\n" + "bottom = " + thumbRect.bottom + "\n");

            float thumbHalf = thumbRect.left + ((thumbRect.right - thumbRect.left) >> 1);
            float newX = thumbHalf - (seekbar_value.getWidth() >> 1);
            Log.e("------", "Width = " + seekbar_value.getWidth() + "   newX = " + newX);
            seekbar_value.setX(newX);
            seekbar_value.setText("" + progress);
        }
        seekbar_value.invalidate();

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    private NumberPicker numpicker;
    private AppCompatTextView heigth;
    /**
     * 退款原因选择
     */
    private ChooseRetuanMoneyReasonPop crmrp;

    private void testNumPicker() {

        heigth = (AppCompatTextView) findViewById(R.id.heigth);
        numpicker = (NumberPicker) findViewById(R.id.numpicker);
        numpicker.setMaxValue(200);
        numpicker.setMinValue(51);
        numpicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        numpicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                heigth.setText("    oldVal = " + oldVal + "    newVal=" + newVal);

            }
        });

        heigth.setOnClickListener(this);

        crmrp = new ChooseRetuanMoneyReasonPop(this);
        crmrp.setOnReason(new ChooseRetuanMoneyReasonPop.OnReason() {

            @Override
            public void getSelect(String content) {
                // TODO Auto-generated method stub
//                tvReason.setText(content);
            }
        });

        if (type == 0) {
            String[] years = {"协商一致退款", "未按约定时间发货", "缺货", "拍错/拍多/不想要", "其它"};
            crmrp.setData(years);
        } else {
            String[] years = {"买多了/买错了", "计划有变，没时间消费", "预约不到", "评价不好", "后悔了，不想要了", "商家说不接待服务券", "商家说可以现金/刷卡付款享受服务券折扣", "其它原因"};
            crmrp.setData(years);
        }


    }

    private void testNewIntent() {

        findViewById(R.id.buttonap).setOnClickListener(this);

    }

    private void testNewIntentOnClick() {

        Intent intentNew = new Intent(context, TestActivity.class);
//        intentNew.putExtra(Constants.TEST_NEW_INTENT, "MainActivity");
        startActivity(intentNew);
    }

    private AppCompatButton buttonap;

    private void testCheck() {

        CheckForAllUtils.isMobileNO("13823214300");
//        CheckForAllUtils.isEmailAdd()

        buttonap = (AppCompatButton) findViewById(R.id.buttonap);
        buttonap.setAlpha(1f);
    }


    private void testIntent() {

        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }


    private AppCompatTextView textview;

    private void testText2() {

        textview = (AppCompatTextView) findViewById(R.id.textview);
        SpannableString spannableString = new SpannableString("舞林至尊");
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.red)), 0, 1, SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.orange)), 1, 2, SPAN_INCLUSIVE_INCLUSIVE);
        textview.setText(spannableString);

    }


    private void testText() {

        textview = (AppCompatTextView) findViewById(R.id.textview);
        /**
         * SPAN_INCLUSIVE_INCLUSIVE  它是用来标识在 Span 范围内的文本前后输入新的字符时是否把它们也应用这个效果
         * SPAN_INCLUSIVE_INCLUSIVE  前面包括，后面也包括  注意是对于输入的字符
         * */
        SpannableString spannableString = new SpannableString("图片-赤橙黄绿青蓝紫|图片");
        ImageSpan imageSpan = new ImageSpan(context, b);
        spannableString.setSpan(imageSpan, 0, 2, SPAN_INCLUSIVE_EXCLUSIVE);// 图片span
        spannableString.setSpan(new BackgroundColorSpan(Color.GREEN), 2, 3, SPAN_INCLUSIVE_EXCLUSIVE);//背景色span
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.red)), 3, 4, SPAN_INCLUSIVE_INCLUSIVE);//前景色span
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.orange)), 4, 5, SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.yellow)), 5, 6, SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.green)), 6, 7, SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.cyan)), 7, 8, SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.blue)), 8, 9, SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R.color.purple)), 9, 10, SPAN_INCLUSIVE_INCLUSIVE);
        spannableString.setSpan(new UnderlineSpan(), 3, 10, SPAN_INCLUSIVE_INCLUSIVE);//下划线span
        spannableString.setSpan(new StrikethroughSpan(), 10, 11, SPAN_INCLUSIVE_INCLUSIVE);//中划线span
        spannableString.setSpan(new ImageSpan(context, R.mipmap.star), 11, 13, SPAN_INCLUSIVE_EXCLUSIVE);

        textview.setText(spannableString);
    }

    private AppCompatEditText edittext;

    private void test7() {


        Log.e("Formatter", "---->Formatter.formatFileSize(context,1234567890);" + "   ---->" + Formatter.formatFileSize(context, 102));
        Log.e("Formatter", "---->Formatter.formatFileSize(context,1024);" + "   ---->" + Formatter.formatFileSize(context, 1024));
        Log.e("Formatter", "---->Formatter.formatFileSize(context,1024*1024*4);" + "   ---->" + Formatter.formatFileSize(context, 1024 * 1024 * 4));
        Log.e("Formatter", "---->Formatter.formatFileSize(context,123456);" + "   ---->" + Formatter.formatFileSize(context, 123456));
        Log.e("Formatter", "---->Formatter.formatFileSize(context,12345678);" + "   ---->" + Formatter.formatFileSize(context, 12345678));
        Log.e("Formatter", "---->Formatter.formatFileSize(context,1234567890);" + "   ---->" + Formatter.formatFileSize(context, 1234567890));
        Log.e("Formatter", "---->Formatter.formatFileSize(context,999999999);" + "   ---->" + Formatter.formatFileSize(context, 999999999));

    }

    private void testParse() {

        Log.e("开始", "");

        Map<String, String> map = new HashMap<String, String>();
//        map.put("username","13823214300");
//        map.put("logincode","123456");
        map.put("mobile", "13823214300");

        RequestParams params = new RequestParams(map);

//        String method = "/Api/login/fastLogin";
        String method = "/Api/agent/getallAreaList";

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(this, "http://admin.wb.uyatest.com" + method, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {


                Log.e("------>", "");

                if (statusCode == 200) {
                    String result = new String(responseBody);
                    Log.e("------>", "" + result);

                    resultTv.setText("成功" + result);

                    try {
                        JSONObject object = new JSONObject(result).getJSONObject("data");

                        SSQModel model = GsonUtils.fromJson(object.toString(), SSQModel.class);

                        Log.e("----->model", "-->" + model.getList().get(0).getAreaname());

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                Log.e("1111111111", "失败");
                resultTv.setText("失败");
            }
        });


    }

    private void testList() {

        List<Model> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {

            Model model = new Model();
            model.setName("名字" + i);
            list.add(model);
        }

        setList((ArrayList<Model>) list);

    }

    private void setList(ArrayList<Model> list) {
        for (int i = 0; i < list.size(); i++) {

            Log.e("---->" + i, "---->" + list.get(i).getName());

        }

    }


    private void testAsync() {

        begin_request = (AppCompatButton) findViewById(R.id.begin_request);
        resultTv = (TextView) findViewById(result);

        begin_request.setOnClickListener(this);

    }

    private AppCompatButton begin_request;
    private TextView resultTv;


    private void test1() {

        Log.e("开始", "");

        Map<String, String> map = new HashMap<String, String>();
//        map.put("username","13823214300");
//        map.put("logincode","123456");
        map.put("mobile", "13823214300");

        RequestParams params = new RequestParams(map);

//        String method = "/Api/login/fastLogin";
        String method = "/Api/login/getLoginCode";

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(this, "http://admin.wb.uyatest.com" + method, params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {


                Log.e("------>", "");

                resultTv.setText("成功");

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                Log.e("1111111111", "失败");
                resultTv.setText("失败");
            }
        });

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked) {
            //设置密码为明文
            edittext.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            //设置密码为密文
            edittext.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }


}
