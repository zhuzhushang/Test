package com.example.testmanythread;

/**
 * Created by Administrator on 2017/3/18.
 */

public class Output2 implements Runnable {

    private Person2 person;

    public Output2(Person2 person) {
        this.person = person;
    }

    @Override
    public void run() {

        while (true) {

                person.output();

        }
    }
}
