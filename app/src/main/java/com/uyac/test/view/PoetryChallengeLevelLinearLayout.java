package com.uyac.test.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.uyac.test.R;

/**
 * Created by noah on 2017/5/24.
 *
 *
 * 诗词挑战显示第几关的linearlayout
 */

public class PoetryChallengeLevelLinearLayout extends LinearLayout{

    private Context context;


    public PoetryChallengeLevelLinearLayout(Context context) {
        super(context);
        init(context);
    }

    public PoetryChallengeLevelLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PoetryChallengeLevelLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {

        this.context = context;
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private int imgID[] = {R.mipmap.num_red_0,R.mipmap.num_red_1,R.mipmap.num_red_2,R.mipmap.num_red_3,R.mipmap.num_red_4,R.mipmap.num_red_5};


    public void setNum(String num)
    {

        removeAllViews();

        for (int i = 0; i < num.length(); i++) {

            final  ImageView image = new ImageView(context);
            int numIndex = Integer.parseInt(""+num.charAt(i));
            image.setImageResource(imgID[numIndex]);
            final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            image.setLayoutParams(params);
            image.setBackgroundColor(Color.BLUE);

            if(numIndex == 4 || numIndex == 5) {
//                image.setScaleX(0.5f);
//                image.setScaleY(0.5f);
                image.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {

                        image.getViewTreeObserver().removeOnPreDrawListener(this);
                        LinearLayout.LayoutParams paramsTemp = (LinearLayout.LayoutParams) image.getLayoutParams();
                        paramsTemp.width = image.getMeasuredWidth() >> 1;
                        paramsTemp.height = image.getMeasuredHeight() >> 1;
                        image.setLayoutParams(paramsTemp);
                        return true;
                    }
                });

            }

            addView(image);
//            requestLayout();
        }
    }

}
