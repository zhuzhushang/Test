package com.example.lockpcmodel;

/**
 * Created by Administrator on 2017/3/21.
 */

public class Production  extends Thread{

    private BoundedBuffer boundedBuffer;

    public Production(BoundedBuffer boundedBuffer){

        this.boundedBuffer = boundedBuffer;
    }


    @Override
    public void run() {
        super.run();

        try {

            while (true)
            {
                boundedBuffer.put(new Object());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
