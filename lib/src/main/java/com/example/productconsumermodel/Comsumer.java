package com.example.productconsumermodel;

/**
 * Created by Administrator on 2017/3/20.
 */

public class Comsumer implements Runnable{


    private StackPlace stackPlace;

    public Comsumer(StackPlace stackPlace) {
        this.stackPlace = stackPlace;
    }

    @Override
    public void run() {

        while (true)
        {

            stackPlace.comsumer();
        }

    }
}
