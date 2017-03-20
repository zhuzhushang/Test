package com.uyac.test.instance;

/**
 * Created by Administrator on 2017/3/17.
 */

public class UserData {


    private static  volatile  UserData userData = null;
    private UserData(){};
    public UserData getInstance()
    {
        if(userData == null)
        {
            synchronized(UserData.this)
            {
                if(userData == null)
                {
                    userData = new UserData();
                }
            }
        }
        return userData;

    }




}
