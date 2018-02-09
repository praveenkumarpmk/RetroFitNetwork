package com.example.praveen.test;


import com.example.praveen.test.model.UserDetail.InputParam;
import com.example.praveen.test.model.UserDetail.LoginResponse;
import com.example.praveen.test.model.UserDetail.UserDetailResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("users/login")
    Call<LoginResponse> doGetListResources(@Body InputParam inputParam, @HeaderMap Map<String, String> headers);

    @POST("/posts/posts")
    Call<UserDetailResponse> getUserDetail(@HeaderMap Map<String, String> headers);

}