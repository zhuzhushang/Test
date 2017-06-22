package com.uyac.test.activity;

import com.uyac.test.R;

/**
 * Created by noah on 2017/5/12.
 */

public class TestTwoActivity extends MainActivity{

    private static final String TAG = "TestTwoActivity";

    @Override
    public void testFunction() {
        super.testFunction();

        inflater.inflate(R.layout.item_test_funtion,container);

    }


}
