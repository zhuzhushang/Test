package com.example.productconsumermodel;

/**
 * Created by Administrator on 2017/3/20.
 */

public class ProductConsumer {

    public static void main(String arg0[])
    {

        StackPlace place = new StackPlace();
        Producter p = new Producter(place);
        Comsumer c = new Comsumer(place);

        for (int i = 0; i < 5; i++) {

            Thread  production = new Thread(p);
            production.start();
        }


        for (int i = 0; i < 3; i++) {

            Thread comsumer = new Thread(c);
            comsumer.setPriority(Thread.MAX_PRIORITY);
            comsumer.start();

        }




    }


}
