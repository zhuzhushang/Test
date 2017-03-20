package com.example.testthread;

/**
 * Created by Administrator on 2017/3/18.
 */

public class InputOutputDemo {

    private static  Person person;

    public static void main(String arge[])
    {
        person = new Person();
        Input input = new Input(person);
        Output output = new Output(person);

        Thread in = new Thread(input);
        Thread out = new Thread(output);

        in.start();
        out.start();

    }



}
