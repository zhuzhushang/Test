package com.uyac.test.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.uyac.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by noah on 2017/5/18.
 */

public class TestButterKnifeActivity extends TestButterKnideBaseActivity {


    @BindView(R.id.radioButton3)
    RadioButton radioButton3;
    @BindView(R.id.textView6)
    TextView textView6;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.toggleButton2)
    ToggleButton toggleButton2;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_test_butter_knife;
    }

    @Override
    void viewInit() {

    }

    @Override
    void dataInit() {

    }

    @Override
    void eventInit() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.radioButton3, R.id.textView6, R.id.button3, R.id.toggleButton2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radioButton3:
                break;
            case R.id.textView6:
                break;
            case R.id.button3:
                break;
            case R.id.toggleButton2:
                break;
        }
    }
}
