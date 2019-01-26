package com.example.armon.androidlearning.myInterface;

import com.example.armon.androidlearning.mybean.ListResponse;
import com.example.armon.androidlearning.mybean.Response;
import com.example.armon.androidlearning.mybean.User;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Armon on 2019/1/24.
 * 用于声明访问服务器 Get 接口的方法
 */

public interface GetService {

    //不带任何参数的 Get 请求
    @GET("Get/getString")
    Call<ResponseBody> getNormal();

    //携带请求参数的 Get 请求
    @GET("Get/getString")
    Call<ResponseBody> getWithQuery(@Query("name") String name, @Query("age") int age);

    //携带请求参数的 Get 请求
    @GET("Get/getString")
    Call<ResponseBody> getWithMap(@QueryMap Map<String, String> map);

    //携带请求参数以及固定请求头的 Get 请求
    @GET("Get/getString")
    @Headers({"userName:leavesC"})
    Call<ResponseBody> getWithQueryAndHeaders(@Query("name") String name, @Query("age") int age);

    //携带请求参数以及请求头值不固定的 Get 请求
    @GET("Get/getString")
    Call<ResponseBody> getWithQueryAndHeader(@Header("userName") String userName, @Query("name") String name, @Query("age") int age);

    //将请求值作为链接一部分的 Get 请求
    @GET("Get/getString/{id}")
    Call<ResponseBody> getWithPath(@Path("id") int id);

    //将请求值作为链接一部分的 Get 请求，并使用 Gson Converter
    @GET("Get/getUser/{startId}/{number}")
    Call<ListResponse<User>> getWithGsonConverter(@Path("startId") int startId, @Path("number") int number);
}
