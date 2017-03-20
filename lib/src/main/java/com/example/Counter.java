package com.example;

/**
 * Created by Administrator on 2017/3/17.
 */

public class Counter {

    public static  volatile  int count = 0;

    public static  void inc() {

        //这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }

//        System.out.println("  "+Thread.currentThread().getId());
//        synchronized (Counter.class)
//        {
            count++;
//        }

//        System.out.println("id = "+Thread.currentThread().getId()+"  运行结果:Counter.count=" + Counter.count);


    }

    public static void main(String[] args) {

        //同时启动1000个线程，去进行i++计算，看看实际结果

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public   void run() {

                        Counter.inc();
                }
            }).start();
        }

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + Counter.count);
    }
}