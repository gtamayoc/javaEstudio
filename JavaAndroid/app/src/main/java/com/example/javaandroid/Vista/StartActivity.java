package com.example.javaandroid.Vista;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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
            Toast.makeText(this, ""+profile.getNombre(), Toast.LENGTH_SHORT).show();
            //Log.e("onFriendClick", String.valueOf(profile.getNombre()));
        } else {

        }

    }

    private void inicializarComponentes() {


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