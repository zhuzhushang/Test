package com.example.lockpcmodel;

/**
 * Created by Administrator on 2017/3/21.
 */

public class pcm {

    public static void main(String arg[])
    {
        BoundedBuffer boundedBuffer = new BoundedBuffer();
        Thread p1 = new Production(boundedBuffer);
        Thread p2 = new Production(boundedBuffer);
        Thread p3 = new Production(boundedBuffer);

        Thread c1 = new Consumer(boundedBuffer);
        Thread c2 = new Consumer(boundedBuffer);


        p1.start();
        p2.start();
        p3.start();

        c1.start();
        c2.start();

    }


}
