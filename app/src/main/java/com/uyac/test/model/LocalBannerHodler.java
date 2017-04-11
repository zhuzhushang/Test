package com.uyac.test.model;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;

/**
 * Created by Administrator on 2017/4/8.
 */

public class LocalBannerHodler implements Holder<Integer> {

    private ImageView imageView;

    @Override
    public View createView(Context context) {

        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Integer data) {

        imageView.setImageResource(data);

    }
}
