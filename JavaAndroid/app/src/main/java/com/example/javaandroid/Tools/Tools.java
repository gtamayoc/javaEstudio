package com.example.javaandroid.Tools;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javaandroid.Modelos.Usuario;

public class Tools {

    AppCompatActivity activity;
    Class<?> activityClass;

    public static void iniciarActivityLogin(AppCompatActivity activity, Class<?> activityClass, Usuario admin){
        Intent intent = new Intent(activity.getApplicationContext(), activityClass);
        intent.setClass(activity, activityClass);
        intent.putExtra("Usuario", admin);
        activity.startActivity(intent);
        //activity.finish();
    }

    public static void iniciarActivityRegister(AppCompatActivity activity, Class<?> activityClass){
        Intent intent = new Intent(activity.getApplicationContext(), activityClass);
        intent.setClass(activity, activityClass);
        activity.startActivity(intent);
        //activity.finish();
    }

    public static void iniciarActivity(AppCompatActivity activity, Class<?> activityClass){
        Intent intent = new Intent(activity.getApplicationContext(), activityClass);
        intent.setClass(activity, activityClass);
        activity.startActivity(intent);
       // activity.finish();
    }

}
