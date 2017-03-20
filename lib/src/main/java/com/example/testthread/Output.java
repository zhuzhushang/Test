package com.example.testthread;

/**
 * Created by Administrator on 2017/3/18.
 */

public class Output implements Runnable{

    private Person person;

    public Output(Person person) {
        this.person = person;
    }

    @Override
    public void run() {

        while (true){
            synchronized (person)
            {
                if(person.isFlag())
                {
                    System.out.println("  "+person.getName()+"--------"+person.getSex());
                    person.setFlag(false);
                    person.notify();

                }else
                    {
                        try {
                            person.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        }

    }
}
