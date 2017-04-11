package com.uyac.test.interfaces;

import com.uyac.test.model.WeatherModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2017/3/29.
 */

public interface GetWeatherData2 {

    @GET("/")  //没有数据就填 . 或者 /
    public Call<WeatherModel> getWeather(@QueryMap Map<String ,String> map); //@GET请求参数对用 @QueryMap ，POST请求参数对应 @FieldMap

}
