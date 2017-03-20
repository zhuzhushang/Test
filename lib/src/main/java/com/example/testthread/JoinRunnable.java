package com.example.testthread;

/**
 * Created by Administrator on 2017/3/19.
 */

public class JoinRunnable implements Runnable {


    @Override
    public void run() {

        for (int i = 0; i < 30; i++) {

            System.out.println("--->"+Thread.currentThread().toString()+"   "+i);
        }

    }
}
