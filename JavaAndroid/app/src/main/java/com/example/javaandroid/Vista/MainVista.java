package com.example.javaandroid.Vista;

import static com.example.javaandroid.Tools.Tools.iniciarActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javaandroid.MainActivity;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.Presentador.MainPresenterRegister;
import com.example.javaandroid.R;
import com.example.javaandroid.interfaces.InterfaceMain;

public class MainVista extends AppCompatActivity implements InterfaceMain.VistaRegistrar {

    ImageButton btn_back;
    EditText et_nombre, et_nombre_usuario, et_clave;
    InterfaceMain.PresenterRegistrar presenterRegistrar;
    TextView tv_estado_registro;
    Button registrar;
    Context ctx;
    Usuario user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vista);
        inicializarComponentes();

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = et_nombre.getText().toString();
                String usuario = et_nombre_usuario.getText().toString();
                String clave = et_clave.getText().toString();
                user.setNombre(nombre);
                user.setUsuario(usuario);
                user.setClave(clave);
                datosVista(user);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = MainVista.this;
                iniciarActivity(activity, MainActivity.class);
            }
        });
    }

    public void inicializarComponentes() {
        ctx = MainVista.this;
        btn_back = findViewById(R.id.imageButton);
        et_nombre= findViewById(R.id.editTextTextPersonName2);
        et_nombre_usuario= findViewById(R.id.editTextTextPersonName3);
        et_clave= findViewById(R.id.editTextNumberPassword);
        tv_estado_registro=findViewById(R.id.textView2);
        registrar = findViewById(R.id.button);
        user = new Usuario();
        presenterRegistrar = new MainPresenterRegister(this, ctx, MainVista.this);
    }

    @Override
    public void datosVista(Usuario user) {
        presenterRegistrar.datosModelo(user);
    }

    @Override
    public void datosLoginVista(Usuario admin) {

    }

    @Override
    public void mostrarErrorMain(String error) {
        Toast.makeText(MainVista.this, ""+error, Toast.LENGTH_SHORT).show();
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