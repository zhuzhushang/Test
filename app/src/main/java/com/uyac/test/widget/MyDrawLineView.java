package com.uyac.test.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;

import com.blankj.utilcode.util.ScreenUtils;
import com.uyac.test.model.DrawLineModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noah on 2017/5/16.
 */

public class MyDrawLineView extends View {

    private static final String TAG = "MyDrawLineView";

    private Paint mPaint;
    private float touchX, touchY;
    private int screenW, screenH;
    private int screenHalfW,screenHalfH;
    private Path mPath;
    private SparseArray<DrawLineModel> mSpraseArray;
    private List<DrawLineModel> mList;


    //画矩形
    private Rect mRect;
    //矩形一般的宽
    private int rectHalfW = 200;

    public MyDrawLineView(Context context) {
        super(context);

        init();
    }

    public MyDrawLineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public MyDrawLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }


    private void init() {

        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        mPaint.setAntiAlias(true);
        mList = new ArrayList<>();
        mSpraseArray = new SparseArray<>();

        mPath = new Path();

        screenW = ScreenUtils.getScreenWidth();
        screenH = ScreenUtils.getScreenHeight();

        screenHalfW = screenW >> 1;
        screenHalfH = screenH >> 1;


        mRect = new Rect(screenHalfW - rectHalfW,screenHalfH - rectHalfW,screenHalfW + rectHalfW,screenHalfH + rectHalfW);
    }


    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);

        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(2);
        canvas.drawLine(touchX,0,touchX,screenH,mPaint);
        canvas.drawLine(0,touchY,screenW,touchY,mPaint);


        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(30);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeJoin(Paint.Join.ROUND);

        canvas.drawRect(mRect,mPaint);


        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        for (int i = 0; i < mList.size(); i++) {


           /* DrawLineModel model = mList.get(i);
            if (i == 0) {

                mPath.moveTo(model.getX(), model.getY());
            } else {
                mPath.lineTo(model.getX(), model.getY());
            }*/

           DrawLineModel model = mList.get(i);
            if (i != 0) {
                DrawLineModel modelFront = mList.get(i - 1);
                canvas.drawLine(modelFront.getX(),modelFront.getY(),model.getX(),model.getY(),mPaint);

            }

            /*DrawLineModel model = mList.get(i);
           canvas.drawCircle(model.getX(),model.getY(),10,mPaint);*/

        }

//        canvas.drawPath(mPath, mPaint);
        canvas.drawPoint(touchX, touchY, mPaint);


        Log.e(TAG, "onDraw: " + touchY + "   " + touchY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        touchX = event.getX();
        touchY = event.getY();

        mList.add(new DrawLineModel(touchX, touchY));

//        requestLayout();
        invalidate();

        return true;
    }
}
