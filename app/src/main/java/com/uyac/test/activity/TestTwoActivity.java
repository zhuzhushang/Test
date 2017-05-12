package com.uyac.test.activity;

import android.util.Log;

import com.uyac.test.R;

/**
 * Created by noah on 2017/5/12.
 */

public class TestTwoActivity extends MainActivity{

    private static final String TAG = "TestTwoActivity";

    @Override
    public void testFunction() {
        super.testFunction();
//        Button button = (Button) findViewById(.id.confirm);
//        button.setText("你好吗");


        Log.e(TAG, "testFunction: fan" );
        testFunctionBtn.setText("你好");

        inflater.inflate(R.layout.item_test_funtion,container,true);

    }


}
