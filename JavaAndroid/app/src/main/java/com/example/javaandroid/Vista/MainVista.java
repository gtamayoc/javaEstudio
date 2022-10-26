package com.example.javaandroid.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javaandroid.MainActivity;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.R;
import com.example.javaandroid.interfaces.InterfaceMain;

public class MainVista extends AppCompatActivity implements InterfaceMain.VistaRegistrar {

    ImageButton btn_back;
    EditText et_nombre, et_nombre_usuario, et_clave;
    TextView tv_estado_registro;
    Button registrar;
    Context ctx;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vista);
        inicializarComponentes();



    }

    public void inicializarComponentes() {
        ctx = MainVista.this;
        btn_back = findViewById(R.id.imageButton);
        et_nombre= findViewById(R.id.editTextTextPersonName2);
        et_nombre_usuario= findViewById(R.id.editTextTextPersonName3);
        et_clave= findViewById(R.id.editTextNumberPassword);
        tv_estado_registro=findViewById(R.id.textView2);
        registrar = findViewById(R.id.registrar);
    }

    @Override
    public void datosLogin(String user, String password) {

    }

    @Override
    public void datosLoginVista(Usuario admin) {

    }

    @Override
    public void mostrarErrorMain(String error) {

    }
}