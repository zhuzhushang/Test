package com.example.lockpcmodel;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/3/21.
 */

public class BoundedBuffer {

    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object items[] = new Object[10];

    int putptr,takeptr,count;

    public void put(Object x) throws InterruptedException
    {
        lock.lock();

        try{
            while (count == items.length)
            {
                System.out.println("生产线程"+Thread.currentThread().toString()+" 当前数量为"+count+"，进入等待");
                notFull.await();
            }

            items[putptr] = x;
            if(++putptr == items.length)
            {
                putptr = 0;
            }
            System.out.println("--------->生产了"+count);
            ++count;
            notEmpty.signalAll();

        }finally {

            lock.unlock();
        }
    }

    public Object take() throws InterruptedException
    {
        lock.lock();
        try {

            while (count == 0){
                System.out.println("消耗线程"+Thread.currentThread().toString()+" 当前数量为0，进入等待");
                notEmpty.await();
            }
            Object x = items[takeptr];
            if(++takeptr == items.length)
            {
                takeptr = 0;
            }
            System.out.println("--------->消耗了"+count);
            --count;
            notFull.signalAll();
            return x;
        }finally {

            lock.unlock();
        }


    }


}
