package com.uyac.test.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.blankj.utilcode.util.LogUtils;

/**
 * Created by noah on 2017/5/5.
 */

public class FromSqwReceiver extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent) {


        LogUtils.e("----------TestApp-----this_is_from_sqw_receiver-----"+intent.getAction());

    }
}
