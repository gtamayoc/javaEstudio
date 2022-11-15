package com.example.javaandroid.API.responses;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("user")
    @Expose()
    private String user;

    @SerializedName("pass")
    @Expose()
    private String pass;

    @SerializedName("token")
    @Expose()
    private String token;

    @SerializedName("message")
    @Expose()
    private String message;

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                ", token='" + token + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
