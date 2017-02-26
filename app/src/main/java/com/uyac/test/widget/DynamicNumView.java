package com.uyac.test.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.uyac.test.R;

/**
 * Created by ShaoQuanwei on 2016/12/15.
 */

public class DynamicNumView extends View {

    private int textSize;
    private int textColor;
    private int drawPathColor;
    private float strokeWidth;
    private Paint mPaint;
    private int num;
    private Handler mHandler;
    private int delayedTime = 500;
    private boolean isRemove = false;


    public DynamicNumView(Context context) {
        this(context, null);
    }

    public DynamicNumView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DynamicNumView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mHandler = new Handler();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        textSize = 30;
        strokeWidth = 1;
        textColor = Color.GREEN;
        drawPathColor = Color.RED;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.dynamic_num_view);
        if (typedArray == null) {
            return;
        }

        for (int i = 0; i < typedArray.getIndexCount(); i++) {

            int attr = typedArray.getIndex(i);

            switch (attr) {
                case R.styleable.dynamic_num_view_textColor:

                    textColor = typedArray.getColor(attr, Color.GREEN);

                    break;
                case R.styleable.dynamic_num_view_textSize:

                    textSize = typedArray.getDimensionPixelSize(attr, 16);

                    break;
                case R.styleable.dynamic_num_view_drawPathColor:

                    drawPathColor = typedArray.getColor(attr, Color.RED);
                    break;
                case R.styleable.dynamic_num_view_strokeWidth:

                    strokeWidth = typedArray.getDimensionPixelSize(attr, 1);
                    break;

            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            width = getPaddingLeft() + widthSize + getPaddingRight();
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            height = getPaddingTop() + heightSize + getPaddingBottom();
        }

        Logger.e("---->width = " + width + "------>height = " + height);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String drawText = "" + num;
        int widthHalf = canvas.getWidth() >> 1;
        int heigthHalf = canvas.getHeight() >> 1;

        Path iPath = new Path();
        iPath.moveTo(0, getHeight());
        iPath.lineTo(0, 0);
        iPath.lineTo(getWidth(), 0);
        iPath.lineTo(getWidth(), getHeight());
        iPath.lineTo(0, getHeight());
        iPath.lineTo(getWidth(), 0);
        iPath.close();


        mPaint.setStrokeWidth(strokeWidth);
        mPaint.setColor(drawPathColor);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(iPath, mPaint);


        Rect rect = new Rect();
        mPaint.getTextBounds(drawText, 0, drawText.length(), rect);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(textColor);
        mPaint.setTextSize(textSize);
        canvas.drawText(drawText, widthHalf - (rect.width() >> 1), heigthHalf - (rect.height() >> 1), mPaint);

        Logger.e("--------->" + num);

    }


    public void startNum() {

        if (isRemove) {
            mHandler.removeCallbacks(runnable);
        } else {
            num = 0;
            mHandler.postDelayed(runnable, delayedTime);
        }
        isRemove = !isRemove;

        Logger.e("----------->" + isRemove);
    }


    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            mHandler.postDelayed(runnable, delayedTime);
            num++;
            requestLayout();
            invalidate();
        }
    };

}
