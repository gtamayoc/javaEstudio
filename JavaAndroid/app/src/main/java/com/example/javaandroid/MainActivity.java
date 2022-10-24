package com.example.javaandroid;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.javaandroid.AsynTaskS.TareaAsincronaLogin;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.Presentador.MainPresenter;
import com.example.javaandroid.interfaces.InterfaceMain;

public class MainActivity extends AppCompatActivity implements InterfaceMain.Vista{

    TextView tv;
    EditText user , password;
    Button ingresar;
    ProgressBar pg;
    InterfaceMain.Presenter presenter;
    Context ctx;
    TareaAsincronaLogin asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ctx = MainActivity.this;
        presenter = new MainPresenter(this, ctx, MainActivity.this);
        inicializarComponentes();
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = user.getText().toString();
                String clave = password.getText().toString();
                datosLogin(usuario,clave);
            }
        });

    }

    public void inicializarComponentes() {
        ctx = this;
        tv = findViewById(R.id.textView);
        user = findViewById(R.id.editTextTextPersonName);
        password = findViewById(R.id.editTextTextPassword);
        ingresar = findViewById(R.id.ingresar);
        pg = findViewById(R.id.progressBar);
    }

    @Override
    public void datosLogin(String user, String password) {
        presenter.datosLogin(user, password);
    }

    @Override
    public void datosLoginVista(Usuario admin) {
        asyncTask = new TareaAsincronaLogin(MainActivity.this,ctx, presenter, admin);
        asyncTask.execute("giuseppe");
        tv.setText(admin.toString());
    }

    @Override
    public void mostrarErrorMain(String error) {
        tv.setText("Su sesion fue : "+error);
    }

}