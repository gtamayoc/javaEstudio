package com.example.javaandroid;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.example.javaandroid.interfaces.InterfaceMain;

public class MainActivity extends AppCompatActivity implements InterfaceMain.VistaLogin {

    TextView tv;
    EditText user , password;
    Button ingresar, registrar;
    ProgressBar pg;
    InterfaceMain.PresenterLogin presenterLogin;
    Context ctx;
    TareaAsincronaLogin asyncTask;

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
                AppCompatActivity activity = MainActivity.this;
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
    }

    public void iniciarActivity(AppCompatActivity mainActivity, Class<MainVista> mainVistaClass){
        Intent intent = new Intent(mainActivity.getApplicationContext(), mainVistaClass);
        mainActivity.startActivity(intent);
    }

    @Override
    public void datosLogin(String user, String password) {
        presenterLogin.datosLogin(user, password);
    }

    @Override
    public void datosLoginVista(Usuario admin) {
        asyncTask = new TareaAsincronaLogin(MainActivity.this,ctx, presenterLogin, admin);
        asyncTask.execute("giuseppe");
        tv.setText(admin.toString());
    }

    @Override
    public void mostrarErrorMain(String error) {
        tv.setText("Su sesion fue : "+error);
    }

}