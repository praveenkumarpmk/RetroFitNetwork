package com.example.praveen.test.model.UserDetail;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserDetailData implements Serializable {

    @SerializedName("posts")
    private UserDetailPost posts;

    public UserDetailPost getPosts() {
        return posts;
    }

    public void setPosts(UserDetailPost posts) {
        this.posts = posts;
    }

}