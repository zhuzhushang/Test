package com.uyac.test.application;

import android.app.Application;
import android.content.Context;

import com.blankj.utilcode.util.Utils;

/**
 * Created by ShaoQuanwei on 2016/12/12.
 */

public class MyApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();


        initConfig();

    }

    private void initConfig() {

        Utils.init(getApplicationContext());

//        CrashHandler crashHandler = CrashHandler.getInstance();
//        crashHandler.init(getApplicationContext());

    }
}
