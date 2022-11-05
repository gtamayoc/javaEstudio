package com.example.javaandroid.Vista;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.R;

public class StartActivity extends AppCompatActivity {

    Button btn_omitir;
    ImageView logo;
    LinearLayout backgroud;
    ConstraintLayout nb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        inicializarComponentes();
        if (getIntent().getSerializableExtra("Usuario") != null) {
            Usuario profile = (Usuario) getIntent().getSerializableExtra("Usuario");
            Toast.makeText(this, ""+profile.getNombre(), Toast.LENGTH_SHORT).show();
            //Log.e("onFriendClick", String.valueOf(profile.getNombre()));
        } else {

        }

        btn_omitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logo.setVisibility(View.GONE);
                backgroud.setVisibility(View.GONE);
                btn_omitir.setVisibility(View.GONE);
                nb.setVisibility(View.VISIBLE);
            }
        });

    }

    private void inicializarComponentes() {
        logo = findViewById(R.id.imageView);
        btn_omitir = findViewById(R.id.button2);
        backgroud = findViewById(R.id.background);
        nb = findViewById(R.id.nav_bar);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Cerrar Aplicacion");

        alertDialogBuilder
                .setMessage("Hola, ¿Deseas Salir de la Aplicación?")
                .setCancelable(false)
                .setPositiveButton("Si",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        dialog.cancel();
                    }
                }).create().show();
    }
}