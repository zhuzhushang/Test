package com.uyac.test.activity;

import android.app.NotificationManager;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.uyac.test.R;
import com.uyac.test.constants.Constants;
import com.uyac.test.service.MyService;

/**
 * Created by ShaoQuanwei on 2016/10/18.
 */

public class TestActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonap:


//                test();
//                testParse();
                testNewIntentOnClick();
                break;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        test();

    }

    private void test() {

//        testNewIntent();
//        testService();

    }

    private NotificationManager notificationManager;


    //测试一些代码还会打不
    private void myNotification()
    {
        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setTicker("1111");
        builder.setContentTitle("这是ContentTitle");
        builder.setContentText("content text");
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        notificationManager.notify(R.mipmap.ic_yaxun_jingpin_collect,builder.build());

    }


    private MyService myService;

    private void testService() {

        Intent intent = new Intent(context, MyService.class);
        bindService(intent,sc, Service.BIND_AUTO_CREATE);
    }


    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            myService = ((MyService.MyBinder)(service)).getService();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            myService = null;
        }
    };



    private AppCompatTextView textview;

    private void testNewIntent() {

        findViewById(R.id.buttonap).setOnClickListener(this);
        textview = (AppCompatTextView) findViewById(R.id.textview);

    }

    private void testNewIntentOnClick() {

        Intent intentNew = new Intent(context,LoginActivity.class);
        intentNew.putExtra(Constants.TEST_NEW_INTENT,"TestActivity");
        startActivity(intentNew);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        textview.setText("onNewIntent()"+"   value = "+intent.getStringExtra(Constants.TEST_NEW_INTENT)+"\n"+"getIntent()"+"  value = "+getIntent().getStringExtra(Constants.TEST_NEW_INTENT));

    }
}