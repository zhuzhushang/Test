package com.uyac.test.interfaces;

import com.uyac.test.model.LoginModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/3/22.
 */

public interface LoginInfo {

    @FormUrlEncoded
    @POST
    public Call<LoginModel> getLoginInfo(@FieldMap Map<String,String> fields);

}
