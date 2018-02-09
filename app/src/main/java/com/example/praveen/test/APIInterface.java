package com.example.praveen.test;


import com.example.praveen.test.model.UserDetail.UserDetailResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("users/login")
    Call<LoginResponse> doGetListResources(@Body InputParam inputParam, @Header("ApplicationId") String ApplicationId);

    @POST("/posts/posts")
    Call<UserDetailResponse> getUserDetail(@Header("Token") String Token,@Header("ApplicationId") String ApplicationId);

}