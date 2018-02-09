package com.example.praveen.test.model.UserDetail;

import com.example.praveen.test.model.UserDetail.User;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("user")
    private User user;

    @SerializedName("token")
    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}