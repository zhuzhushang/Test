package com.uyac.test.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.uyac.test.utils.ToastUtils;

/**
 * Created by noah on 2017/4/11.
 */

public class TestIntentServiceReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

        ToastUtils.show(context,"收到广播"+intent.getAction());
    }
}
