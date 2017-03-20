package com.example.testmanythread;

/**
 * Created by Administrator on 2017/3/18.
 */

public class Input2 implements Runnable {

    private Person2 person;

    public Input2(Person2 person) {
        this.person = person;
    }

    @Override
    public void run() {

        boolean isRun = true;

        while (true) {


            if (isRun) {

                person.input("mike", "man");

            } else {

                person.input("丽丽", "女");
            }

            isRun = !isRun;

        }
    }
}
