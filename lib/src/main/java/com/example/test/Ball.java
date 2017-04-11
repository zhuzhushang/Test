package com.example.test;

import com.example.interfaces.MyInterface;

/**
 * Created by Administrator on 2017/3/26.
 */

public class Ball implements MyInterface{

    private String name;

    public static void  main(String arg0[]){

        Ball ball = new Ball();
        ball.play();


    }

    public Ball(){


    }

    public Ball(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {

        System.out.println(""+ball.getName());

    }
}
