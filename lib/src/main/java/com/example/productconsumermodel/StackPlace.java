package com.example.productconsumermodel;

/**
 * Created by Administrator on 2017/3/20.
 */

public class StackPlace {


    ManTou manTouArray[] = new ManTou[10];

    private int index = 0;

    public synchronized void producter(ManTou manTou)
    {
        while(index == manTouArray.length)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("------>生产"+Thread.currentThread().toString()+"   "+(index+1));
        index++;
        manTouArray[index] = manTou;
        notifyAll();
    }


    public synchronized ManTou comsumer()
    {
        while (index == -1)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("------------>消耗"+Thread.currentThread().toString()+"   "+(index+1));

        ;
        return manTouArray[index--];

    }







}
