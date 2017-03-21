package com.example.lockpcmodel;

/**
 * Created by Administrator on 2017/3/21.
 */

public class Consumer extends Thread{

    private BoundedBuffer boundedBuffer;

    public Consumer(BoundedBuffer boundedBuffer){

        this.boundedBuffer = boundedBuffer;
    }



    @Override
    public void run() {
        super.run();

        try {

            while (true)
            {

                boundedBuffer.take();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
