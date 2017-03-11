package com.uyac.test.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.uyac.test.R;

/**
 * Created by Administrator on 2017/3/7.
 */

public class CirCleProgressView extends View{

    private Paint mPaint;
    private Context context;
    private int screenW,screenH;
    private int centerX,centerY,radius;
    private RectF mRectf;

    private int percent;

    public CirCleProgressView(Context context) {
        super(context);
        init(context);
    }


    public CirCleProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }


    private void init(Context context) {

        this.context = context;
        mPaint = new Paint();


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


//        setMeasuredDimension();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        screenW = canvas.getWidth();
        screenH = canvas.getHeight();
        centerX = canvas.getWidth() >> 1;
        centerY = canvas.getHeight() >> 1;
        radius = canvas.getWidth() >> 2;

        mRectf = new RectF(centerX - radius,centerY - radius,centerX+radius,centerY+radius);


        mPaint.setTextSize(getResources().getDimensionPixelOffset(R.dimen.textsize_max_x));
        mPaint.setColor(Color.BLACK);
        canvas.drawLine(centerX,0,centerX,screenH,mPaint);
        canvas.drawLine(0,centerY,screenW,centerY,mPaint);

        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        canvas.drawRect(mRectf,mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawCircle(centerX,centerY,radius,mPaint);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);


        canvas.drawArc(mRectf,-90,percent * 360 / 100,true,mPaint);
        mPaint.setColor(Color.YELLOW);
        mPaint.setTextAlign(Paint.Align.CENTER);


        canvas.drawText(percent+"%",centerX,centerY,mPaint);
//        drawTextCenter(canvas,"SHAOshao_fan_FAN_g_G",centerX,centerY,mPaint);

    }


    private void drawTextCenter(Canvas canvas,String text,int centerX,int centerY,Paint paint)
    {
        Rect rect = new Rect();
        paint.getTextBounds(text,0,text.length(),rect);
        paint.setTextAlign(Paint.Align.CENTER);
        int newY = (rect.bottom - rect.top)/2 + centerY;
        canvas.drawText(text,centerX,newY,paint );

    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;

        invalidate();

    }
}
