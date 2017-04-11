package com.uyac.test.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.uyac.test.receiver.TestIntentServiceReceiver;

/**
 * Created by noah on 2017/4/11.
 */

public class MyIntentService extends IntentService{

    private final String TAG = "MyIntentService";

    public MyIntentService() {
        super("");

        Log.e(TAG, "MyIntentService: " );
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService(String name) {
        super(name);

        Log.e(TAG, "MyIntentService: "+name );
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.e(TAG, "onHandleIntent: "+intent.getStringExtra("123") );

        Intent intentNoah = new Intent(getApplicationContext(), TestIntentServiceReceiver.class);
       intent.setAction("noah");

        //先注册广播
        TestIntentServiceReceiver receiver = new TestIntentServiceReceiver();
        IntentFilter filter = new IntentFilter();
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver,filter);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intentNoah);
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);

        Log.e(TAG, "onHandleIntent: "+"发送广播成功" );

    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e(TAG, "onCreate: " );
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {

        Log.e(TAG, "onStartCommand: flags = "+flags+"   startId = "+startId );

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.e(TAG, "onDestroy: " );
    }
}
