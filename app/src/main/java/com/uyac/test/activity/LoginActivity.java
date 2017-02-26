package com.uyac.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.uyac.test.R;
import com.uyac.test.values.Constants;

/**
 * Created by ShaoQuanwei on 2016/11/11.
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonap:


//                test();
//        testParse();
                testNewIntentOnClick();

                break;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        test();

    }

    private void test() {

        testNewIntent();

    }

    private void testNewIntent() {

        findViewById(R.id.buttonap).setOnClickListener(this);

    }

    private void testNewIntentOnClick() {

        Intent intentNew = new Intent(context,TestActivity.class);
        intentNew.putExtra(Constants.TEST_NEW_INTENT,"LoginActivity");
        startActivity(intentNew);
    }
}