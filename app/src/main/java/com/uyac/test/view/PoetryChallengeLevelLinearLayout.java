package com.uyac.test.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
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
    
    private int imgID[] = {R.mipmap.num_red_0,R.mipmap.num_red_1,R.mipmap.num_red_2,R.mipmap.num_red_3,R.mipmap.num_red_4,R.mipmap.num_red_5};


    public void setNum(String num)
    {

        removeAllViews();

        for (int i = 0; i < num.length(); i++) {

            ImageView image = new ImageView(context);
            int numIndex = Integer.parseInt(""+num.charAt(i));
            image.setImageResource(imgID[numIndex]);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            image.setLayoutParams(params);

            if(numIndex == 4 || numIndex == 5)
            {
                image.setScaleX(0.5f);
                image.setScaleY(0.5f);
            }

            addView(image);
        }
        
        
    }

}
