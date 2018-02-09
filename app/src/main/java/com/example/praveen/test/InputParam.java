package com.example.praveen.test;

import java.io.Serializable;

/**
 * Created by H285837 on 2/8/2018.
 */

public class InputParam implements Serializable {

    private String email;
    private String password;

    public InputParam(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
