package com.example.testmanythread;

/**
 * Created by Administrator on 2017/3/18.
 */

public class Person2 {

    private String name;
    private String sex;
    private boolean flag;
    private int index = 1;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public synchronized void input(String name ,String sex)
    {
        while(flag)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.sex = sex;

        System.out.println("----->生产"+Thread.currentThread().toString()+"   "+(++index));

        flag = true;
        this.notifyAll();

    }

    public synchronized void output()
    {

        while(!flag)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("------------>消费"+Thread.currentThread().toString()+"   "+index);
        flag = false;
        this.notifyAll();
    }

}
