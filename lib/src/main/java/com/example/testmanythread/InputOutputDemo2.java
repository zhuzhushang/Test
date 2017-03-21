package com.example.testmanythread;

/**
 * Created by Administrator on 2017/3/18.
 */

public class InputOutputDemo2 {

    private static  Person2 person;

    public static void main(String arge[])
    {
        person = new Person2();
        Input2 input = new Input2(person);
        Output2 output = new Output2(person);

        Thread in = new Thread(input);
        Thread out = new Thread(output);
        Thread in1 = new Thread(input);
        Thread out1 = new Thread(output);

        in.start();
        out.start();
        in1.start();
        out1.start();
    }
}
