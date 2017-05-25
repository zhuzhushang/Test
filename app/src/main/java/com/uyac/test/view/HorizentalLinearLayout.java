package com.uyac.test.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ScreenUtils;

/**
 * Created by noah on 2017/5/24.
 */

public class HorizentalLinearLayout extends LinearLayout{

    private Context context;

    public HorizentalLinearLayout(Context context) {
        super(context);

        init(context);
    }

    public HorizentalLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public HorizentalLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        setMeasuredDimension(ScreenUtils.getScreenWidth() >> 1,ScreenUtils.getScreenHeight() >> 1);

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }
}
