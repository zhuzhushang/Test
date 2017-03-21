package com.example.productconsumermodel;

/**
 * Created by Administrator on 2017/3/20.
 */

public class StackPlace {


    ManTou manTouArray[] = new ManTou[10];

    private int index = -1;

    public synchronized void producter(ManTou manTou)
    {
        while(index == manTouArray.length - 1)
        {
            try {

                System.out.println("xxxxxxxxx生产已满"+Thread.currentThread().toString()+"   ");

                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("------>生产"+Thread.currentThread().toString()+"   "+(index+1));
        index++;
        manTouArray[index] = manTou;
        this.notifyAll();
    }


    public synchronized ManTou comsumer()
    {
        while (index == -1)
        {
            try {
                System.out.println("xxxxxxxxxx消耗已光"+Thread.currentThread().toString()+"   ");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("------------>消耗"+Thread.currentThread().toString()+"   "+(index));

        this.notifyAll();
        return manTouArray[index--];


    }


}
