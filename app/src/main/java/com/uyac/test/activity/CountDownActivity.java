package com.uyac.test.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.uyac.test.R;

import java.util.Timer;
import java.util.TimerTask;

public class CountDownActivity extends BaseActivity {


    private static final String TAG = "CountDownActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);

        testCountDown();
    }

    private void testCountDown(){

        CountDownTimer countDownTimer = new CountDownTimer(3000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                Log.e(TAG, "onTick: "+ millisUntilFinished);
            }

            @Override
            public void onFinish() {

                Log.e(TAG, "onFinish: " );
            }
        };

        countDownTimer.start();
//        countDownTimer.cancel();
    }



    private void testCountDown2() {


        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                Log.e(TAG, "testCountDown: end  currentTimeMillis = "+System.currentTimeMillis() );
                Log.e(TAG, "run: "+Thread.currentThread() );
                timer.cancel();
//                Toast.makeText(context,"时间到",Toast.LENGTH_LONG).show(); //time线程不能改变UI
//                startActivity(MainActivity.class);//不能更新UI，但是可以启动activity

            }
        };
        Log.e(TAG, "testCountDown: start  currentTimeMillis = "+System.currentTimeMillis() );
        timer.schedule(timerTask,3000);
    }

    private void testCountDown1() {

        Log.e(TAG, "testCountDown: start  currentTimeMillis = "+System.currentTimeMillis() );

        countDownHandler.postDelayed(countDownRunnable,3000);
    }

    Handler countDownHandler = new Handler();
    Runnable countDownRunnable = new Runnable() {
        @Override
        public void run() {

            Toast.makeText(context,"时间到",Toast.LENGTH_LONG).show();
            Log.e(TAG, "testCountDown: end  currentTimeMillis = "+System.currentTimeMillis() );
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(countDownHandler != null)
        {
            //移除回调，避免内存泄漏
            countDownHandler.removeCallbacks(countDownRunnable);
        }
    }
}
