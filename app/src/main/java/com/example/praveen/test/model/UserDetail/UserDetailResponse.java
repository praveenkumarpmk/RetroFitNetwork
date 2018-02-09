package com.example.praveen.test.model.UserDetail;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserDetailResponse implements Serializable {

    @SerializedName("status")
    private String status;
    @SerializedName("data")
    private UserDetailData data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserDetailData getData() {
        return data;
    }

    public void setData(UserDetailData data) {
        this.data = data;
    }

}