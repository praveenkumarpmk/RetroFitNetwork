package com.example.praveen.test.model.UserDetail;

import java.io.Serializable;

public class UserInputParam implements Serializable {

    private String ApplicationId;
    private String Token;

    public UserInputParam(String applicationId, String token) {
        ApplicationId = applicationId;
        Token = token;
    }

    public String getApplicationId() {
        return ApplicationId;
    }

    public void setApplicationId(String applicationId) {
        ApplicationId = applicationId;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }
}
