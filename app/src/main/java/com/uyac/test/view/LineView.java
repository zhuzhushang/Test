package com.uyac.test.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by noah on 2017/5/24.
 */

public class LineView extends View{

    private Paint mPaint;

    public LineView(Context context) {
        super(context);

        init(context);

    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }


    private void init(Context context) {

        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth();
        int heigth = canvas.getHeight();
        mPaint.setColor(Color.BLACK);
        canvas.drawLine(0,heigth >> 1,width,heigth >> 1,mPaint);
        canvas.drawLine(width >> 1,0,width >> 1,heigth,mPaint);


    }
}
