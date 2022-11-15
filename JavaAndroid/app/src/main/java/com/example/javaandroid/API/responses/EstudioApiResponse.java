package com.example.javaandroid.API.responses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EstudioApiResponse {

    @SerializedName("Title")
    @Expose()
    private String Title;

    public String getTitle() {
        return Title;
    }

    @Override
    public String toString() {
        return "EstudioApiResponse{" +
                "Title=" + Title +
                '}';
    }
}