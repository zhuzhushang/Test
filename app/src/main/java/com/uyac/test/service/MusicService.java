package com.uyac.test.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.uyac.test.utils.StringUtils;

import java.io.IOException;

/**
 * Created by Administrator on 2017/3/8.
 */

public class MusicService extends Service implements  MediaPlayer.OnCompletionListener {

    private String TAG = "MusicService";
    private MediaPlayer mediaPlayer;
    //需要外置储存卡有这个音乐文件
    private String path = Environment.getExternalStorageDirectory() + "/" + "123.aac";
    private String path1 = Environment.getExternalStorageDirectory() + "/" + "po.mp3";
    //当前歌曲
    private String currentMusic;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public final IBinder binder = new MyBinder();



    @Override
    public void onCompletion(MediaPlayer mp) {


    }

    public class MyBinder extends Binder {
        public MusicService getService() {

            return MusicService.this;
        }
    }


    /**
     * 开始播放
     */
    public void start(final String path) {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            try {
                //重置 有必要
                mediaPlayer.reset();
                //设置播放数据
                mediaPlayer.setDataSource(path);
                //准备
                mediaPlayer.prepare();
                //准备完成监听
                mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {

                        //准备完开始播放
                        mediaPlayer.start();
                        currentMusic = path;
                    }
                });


            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {

            //再次初始化和继续播放
            mediaPlayer = new MediaPlayer();
            start(path);

        }
    }

    public void start() {
        if (mediaPlayer != null && !StringUtils.isEmpty(currentMusic)) {

            mediaPlayer.start();
        } else {

            start(path);

        }
    }


    /**
     * 暂停
     */
    public void pause() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }

    }

    /**
     * 停止
     */
    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            currentMusic = "";
        }
    }

}
