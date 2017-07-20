package com.uyac.test.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.blankj.utilcode.util.ScreenUtils;

/**
 * Created by noah on 2017/7/20.
 */

public class MyGridView extends View{

    private  int row,col;
    private Context context;
    private Paint mPaint;
    private int screenW,screenH;

    public MyGridView(Context context,int row,int col) {
        super(context);

        this.context = context;
        this.row = row;
        this.col = col;

        init();
    }

    private void init() {

        if(row <= 0)row = 1;
        if(col <= 0)col = 1;

        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);



        setMeasuredDimension(ScreenUtils.getScreenWidth(),ScreenUtils.getScreenHeight());

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = canvas.getWidth();
        int height = canvas.getHeight();

        float cutWidth = 1.0f * width / (row + 1) ;
        float cutHeight = 1.0f * height / (col + 1);

        cutWidth = 5;
        cutHeight = 5;

        for (int i = 0; i <= row; i++) {

            float startX = 0;
            float startY = cutHeight + cutHeight * i;
            float stopX = width;
            float stopY = cutHeight + cutHeight * i;
            canvas.drawLine(startX,startY,stopX,stopY,mPaint);

        }

        for (int i = 0; i < col; i++) {

            float startX = cutWidth + cutWidth * i;
            float startY = 0;
            float stopX = cutWidth + cutWidth * i;
            float stopY = height;
            canvas.drawLine(startX,startY,stopX,stopY,mPaint);
            
        }

    }
}
