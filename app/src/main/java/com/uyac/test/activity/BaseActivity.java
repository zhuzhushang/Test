package com.uyac.test.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @author android
 * @Description: 类描述
 */
public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";
    public Context context;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        context = this;
        //

        // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        // SystemBarTintManager tintManager = new SystemBarTintManager(this);
        // tintManager.setTranslucentStatus(this);
        // tintManager.setStatusBarTintEnabled(true);
        // tintManager.setStatusBarTintResource(R.color.status_bg);
        //

    }


    public void startActivity(Class<?> cls)
    {
        Intent intent = new Intent(context,cls);
        startActivity(intent);
    }





}
