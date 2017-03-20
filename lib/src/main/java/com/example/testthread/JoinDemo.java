package com.example.testthread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/3/19.
 */

public class JoinDemo {

    public static void main(String arg[]) throws Exception
    {

        JoinRunnable runnable = new JoinRunnable();

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
        t2.setPriority(Thread.MAX_PRIORITY);
//        t1.join();


        for (int i = 0; i < 30; i++) {

            Lock lock = new ReentrantLock();
            lock.newCondition();
            lock.lock();
            lock.unlock();

//            System.out.println(" "+Thread.currentThread().getName()+"  "+Thread.currentThread().getId()+"  "+i);
            System.out.println("    "+Thread.currentThread().toString()+"   "+i);
        }


    }


}
