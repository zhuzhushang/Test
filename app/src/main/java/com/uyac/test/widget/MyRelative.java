package com.uyac.test.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2017/4/30.
 */

public class MyRelative extends RelativeLayout{


    public MyRelative(Context context) {
        super(context);
    }

    public MyRelative(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelative(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        setMeasuredDimension(widthSize,200);
    }
}
