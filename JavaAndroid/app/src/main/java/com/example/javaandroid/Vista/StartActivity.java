package com.example.javaandroid.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.R;

public class StartActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        inicializarComponentes();
        if (getIntent().getSerializableExtra("Usuario") != null) {
            Usuario profile = (Usuario) getIntent().getSerializableExtra("Usuario");

            //Log.e("onFriendClick", String.valueOf(profile.getNombre()));
        } else {

        }

    }

    private void inicializarComponentes() {


    }
}