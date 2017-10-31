package com.uyac.test.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.LogUtils;

/**
 * Created by Administrator on 2017/10/25 0025.
 */

public class CustomView extends View{

    private Context context;
    private int count = 0;

    public CustomView(Context context) {
        this(context,null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        LogUtils.e("----------->  onAttachedToWindow");

        LinearLayout linear = (LinearLayout) getParent();
        if(linear != null){
            LogUtils.e("----------------->  onAttachedToWindow    "+linear.getHeight());

        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        LogUtils.e("-------> onMeasure"+"  调用了"+(++count)+"次");

        int heiht = ((LinearLayout)(getParent())).getHeight();
        LogUtils.e("-------> onMeasure"+"  heiht = "+heiht);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        LogUtils.e("--------> onLayout"+ "  left = "+left+"   top = "+ top+"   right = "+right+"   bottom = "+bottom );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        LogUtils.e("-----------> onDraw");
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);


        LogUtils.e("-----------> onSizeChanged");
    }

    private void init() {




        LogUtils.e("-----------> init");


    }
}
