package com.uyac.test.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2017/3/16.
 */

public class PacManView extends View {

    private String TAG = "PacManView";

    private Paint mPaint;
    private Context context;
    private int screenW, screenH;
    private int centerX, centerY;
    private RectF rectF;

    //
    private int pacManLeft;
    private int pacManUp;


    private int pacManRadius;

    private int startAngle, endAngle;

    //眼睛的半径
    private int eyeRadius = 50;

    //zui open close
    private boolean isOpen = true;
    private int angleRate = 15;

    private Handler handler;

    private MyThread myThread;


    private boolean isRun = true;

    //初始值
    private int initValue = 100;

    public PacManView(Context context) {
        super(context);

        init(context);
    }

    public PacManView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PacManView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {
        this.context = context;
        mPaint = new Paint();
        pacManLeft = 5;
        pacManUp = 5;
        pacManRadius = initValue;


        eyeRadius = initValue >> 3;
        startAngle = 45;
        endAngle = 270;


        handler = new Handler();
        rectF = new RectF(pacManLeft, pacManUp, pacManLeft + pacManRadius, pacManUp + pacManRadius);

//        handler.postDelayed(runnable, 500);

        myThread = new MyThread();
        myThread.start();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        screenW = canvas.getWidth();
        screenH = canvas.getHeight();
        centerX = canvas.getWidth() >> 1;
        centerY = canvas.getHeight() >> 1;

        mPaint.setColor(Color.WHITE);
        canvas.drawRect(0,0,screenW,screenH,mPaint);

        mPaint.setColor(Color.YELLOW);
        mPaint.setStyle(Paint.Style.FILL);
//        canvas.drawCircle(centerX,centerY,pacManRadius,mPaint);
        canvas.drawArc(rectF, startAngle, endAngle, true, mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawCircle(rectF.left + (pacManRadius >> 1), rectF.top + (pacManRadius >> 2), eyeRadius, mPaint);


    }



    public class MyThread extends Thread
    {

        @Override
        public void run() {
            super.run();

            while (isRun)
            {
                Log.e(TAG, "run: "+isOpen+"  startAngle = "+startAngle+"  endAngle"+endAngle);
                if (isOpen) {
                    startAngle = startAngle - angleRate;
                    endAngle = endAngle + (angleRate << 1);

                    if(startAngle == 0)
                    {
                        isOpen = false;
                    }


                } else {

                    startAngle = startAngle + angleRate;
                    endAngle = endAngle - (angleRate << 1);

                    if(startAngle == 45)
                    {
                        isOpen = true;
                    }
                }

                try {
                    Thread.sleep(150);
//                    invalidate();
                    postInvalidate();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();

        isRun = false;
    }
}
