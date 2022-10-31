package com.example.javaandroid;

import static com.example.javaandroid.Tools.Tools.iniciarActivity;
import static com.example.javaandroid.Tools.Tools.iniciarActivityLogin;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.javaandroid.AsynTaskS.TareaAsincronaLogin;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.Presentador.MainPresenterLogin;
import com.example.javaandroid.Vista.MainVista;
import com.example.javaandroid.Vista.StartActivity;
import com.example.javaandroid.interfaces.InterfaceMain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements InterfaceMain.VistaLogin {

    TextView tv;
    EditText user , password;
    Button ingresar, registrar;
    ProgressBar pg;
    InterfaceMain.PresenterLogin presenterLogin;
    Context ctx;
    TareaAsincronaLogin asyncTask;
    AppCompatActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentes();
        presenterLogin = new MainPresenterLogin(this, ctx, MainActivity.this);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = user.getText().toString();
                String clave = password.getText().toString();
                datosLogin(usuario,clave);
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarActivity(activity, MainVista.class);
            }
        });
    }

    public void inicializarComponentes() {
        ctx = MainActivity.this;
        tv = findViewById(R.id.textView);
        user = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPassword);
        ingresar = findViewById(R.id.ingresar);
        registrar = findViewById(R.id.registrar);
        pg = findViewById(R.id.progressBar);
        activity = MainActivity.this;
    }

    @Override
    public void datosLogin(String user, String password) {
        presenterLogin.datosLogin(user, password);
    }

    @Override
    public void datosLoginVista(Usuario admin) {
        iniciarActivityLogin(activity, StartActivity.class, admin);
    }

    @Override
    public void mostrarErrorMain(String error) {
        tv.setVisibility(View.VISIBLE);
        tv.setText(""+error);
    }

    @Override
    public void mostrarErrorCampos(String error) {
        CharSequence chse = error;
        user.setError(" "+error);
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