package com.uyac.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.uyac.test.R;
import com.uyac.test.values.Constants;

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

        testNewIntent();

    }

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