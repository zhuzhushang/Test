package com.uyac.test.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/3/1.
 */

public class WaveView extends View {


    private Paint paint;
    private Path path;
    private Bitmap mBitmap;
    private int dx;
    int dy;
    private int width;
    private int heigth;


    /**/


    public WaveView(Context context) {
        super(context);
    }

    public WaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WaveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }







}
