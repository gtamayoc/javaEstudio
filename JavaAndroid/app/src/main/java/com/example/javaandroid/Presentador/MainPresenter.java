package com.example.javaandroid.Presentador;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javaandroid.Modelo.MainModelo;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.interfaces.InterfaceMain;

public class MainPresenter implements InterfaceMain.Presenter {

    InterfaceMain.Vista vista;
    InterfaceMain.Modelo modelo;
    Usuario admin;

    public MainPresenter(InterfaceMain.Vista vista, Context ctx, AppCompatActivity activity) {
        this.vista = vista;
        this.modelo = new MainModelo(MainPresenter.this, ctx, activity);
    }

    @Override
    public void datosLogin(String usuario, String clave) {
        if(!usuario.equals("") && !clave.equals("")){
            modelo.logearCredenciales(usuario,clave);
        }else{
            mostrarErrorPresenter("Credenciales No VALIDAS");
        }
    }

    @Override
    public void datosLoginVista(Usuario admin) {
        vista.datosLoginVista(admin);
    }

    @Override
    public void mostrarErrorPresenter(String error) {
        vista.mostrarErrorMain(error);
    }
}
