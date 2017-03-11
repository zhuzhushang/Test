package com.uyac.test.activity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;

import com.uyac.test.R;

/**
 * Created by Administrator on 2017/3/8.
 */

public class SensorActivity extends BaseActivity implements SensorEventListener {

    private String TAG = "SensorActivity";
    private SensorManager sensorManager;
    private Sensor accelerat;
    private Vibrator vibrator;
    private int maxValue = 3;
    private long patter[] = {0,1000};

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);

        setContentView(R.layout.activity_sensor);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerat = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
    }

    @Override
    protected void onResume() {
        super.onResume();

        sensorManager.registerListener(this,accelerat,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();

        sensorManager.unregisterListener(this,accelerat);

    }


    private long recordTime;

    @Override
    public void onSensorChanged(SensorEvent event) {

        if(event.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION)
        {
            float value[] = event.values;

            Log.e(TAG, "x = "+value[0]+"  y="+value[1]+"  z="+value[2]);

            float x = value[0];
            float y = value[1];
            float z = value[2];


            if(Math.abs(x) > maxValue || Math.abs(y) > maxValue || Math.abs(z) > maxValue)
            {
                if( System.currentTimeMillis() - recordTime > 500)
                {
                    vibrator.vibrate(100);
                    recordTime = System.currentTimeMillis();
                }
            }

        }


    }

    /**
     * 传感器精度变化时会调用
     * @param sensor
     * @param accuracy
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vibrator.cancel();
    }
}
