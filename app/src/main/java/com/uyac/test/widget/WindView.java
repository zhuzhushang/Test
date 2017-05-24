package com.uyac.test.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by noah on 2017/5/20.
 */

public class WindView extends SurfaceView implements SurfaceHolder.Callback,Runnable{


    private boolean isRun;

    public WindView(Context context) {
        super(context);

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);

    }

    public WindView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WindView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        isRun = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        isRun = false;
    }

    @Override
    public void run() {


        while (isRun)
        {

        }


    }
}
