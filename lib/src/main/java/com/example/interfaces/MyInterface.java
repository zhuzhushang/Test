package com.example.interfaces;

import com.example.test.Ball;

/**
 * Created by Administrator on 2017/3/26.
 */

public interface MyInterface extends OnTestBall1,OnTestBall2 {

    Ball ball = new Ball("name");

}
