package com.example.testthread;

/**
 * Created by Administrator on 2017/3/18.
 */

public class Input implements Runnable {

    private Person person;

    public Input(Person person) {
        this.person = person;
    }

    @Override
    public void run() {

        boolean isRun = true;

        while (true) {

            synchronized (person)
            {
                if(person.isFlag())
                {
                    try {
                        person.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else
                    {
                        if (isRun) {
                            person.setName("mike");
                            person.setSex("man");
                        } else {
                            person.setName("丽丽");
                            person.setSex("女");
                        }

                        isRun = !isRun;
                        person.setFlag(true);
                        person.notify();

                    }

            }
        }
    }
}
