package com.uyac.test.interfaces;

import com.uyac.test.model.LoginModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2017/3/22.
 */

public interface LoginInfo {

    @FormUrlEncoded
    @GET("/")
    public Call<LoginModel> getLoginInfo(@QueryMap Map<String,String> fields);

}
