package com.uyac.test.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.uyac.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by noah on 2017/6/20.
 */

public class TestThreeActivity extends AppCompatActivity {

    @BindView(R.id.textView8)
    TextView textView8;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.checkBox2)
    CheckBox checkBox2;
    @BindView(R.id.spinner3)
    Spinner spinner3;
    @BindView(R.id.progressBar5)
    ProgressBar progressBar5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_three);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.textView8, R.id.button5, R.id.checkBox2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.textView8:
                break;
            case R.id.button5:
                break;
            case R.id.checkBox2:
                break;
        }
    }
}

