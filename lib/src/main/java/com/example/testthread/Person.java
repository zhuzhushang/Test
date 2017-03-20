package com.example.testthread;

/**
 * Created by Administrator on 2017/3/18.
 */

public class Person {

    private String name;
    private String sex;
    private boolean flag;

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
        if(flag)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.sex = sex;

        flag = true;
        this.notify();

    }

    public synchronized void output()
    {

        if(!flag)
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("------>"+name+ "   "+sex);
        flag = false;
        this.notify();
    }


}
