package com.uyac.test.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;

/**
 * Created by noah on 2017/4/26.
 */

public class MyFrameLayout extends FrameLayout{
    public MyFrameLayout(@NonNull Context context) {
        super(context);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);



    }
}
