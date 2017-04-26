package com.uyac.test.interfaces;

import com.uyac.test.model.WeatherModel;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2017/3/29.
 */

public interface GetWeatherData {

    @FormUrlEncoded  //post请求必须加上
    @POST("/")      //没有数据就填 . 或者 /
    public Call<WeatherModel> getWeather(@FieldMap Map<String,String> map); //POST请求参数对应 @FieldMap ，@GET请求参数对用 @QueryMap

    @FormUrlEncoded  //post请求必须加上
    @POST("/")      //没有数据就填 . 或者 /
    public Observable<WeatherModel> followers(@FieldMap Map<String,String> map); //POST请求参数对应 @FieldMap ，@GET请求参数对用 @QueryMap

}
