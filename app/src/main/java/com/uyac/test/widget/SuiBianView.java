package com.uyac.test.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ShaoQuanwei on 2016/12/16.
 */

public class SuiBianView extends View{

    private Paint mPaint;


    public SuiBianView(Context context) {
        this(context,null);
    }

    public SuiBianView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SuiBianView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();


    }


    private int padding = 60;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int widthHalf = canvas.getWidth() >> 1;
        int heigthHalf = canvas.getHeight() >> 1;

        mPaint.setStrokeWidth(3);
        mPaint.setColor(Color.GREEN);
        canvas.drawLine(0,0,canvas.getWidth(),canvas.getHeight(),mPaint);


         Path iPath = new Path();
        iPath.moveTo(0 + padding, 0 + padding);
        iPath.lineTo(getWidth() + padding, 0 + padding);
        iPath.lineTo(getWidth()  - padding, getHeight() - padding);
        iPath.lineTo(0 - padding, getHeight() - padding);
        iPath.close();


        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(iPath,mPaint);





    }
}
