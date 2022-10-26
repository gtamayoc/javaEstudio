package com.example.javaandroid.Presentador;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javaandroid.Modelo.MainModeloLogin;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.interfaces.InterfaceMain;

public class MainPresenterLogin implements InterfaceMain.PresenterLogin {

    InterfaceMain.VistaLogin vistaLogin;
    InterfaceMain.ModeloLogin modeloLogin;
    Usuario admin;

    public MainPresenterLogin(InterfaceMain.VistaLogin vistaLogin, Context ctx, AppCompatActivity activity) {
        this.vistaLogin = vistaLogin;
        this.modeloLogin = new MainModeloLogin(MainPresenterLogin.this, ctx, activity);
    }

    @Override
    public void datosLogin(String usuario, String clave) {
        if(!usuario.equals("") && !clave.equals("")){
            modeloLogin.logearCredenciales(usuario,clave);
        }else{
            mostrarErrorPresenter("Credenciales No VALIDAS");
        }
    }

    @Override
    public void datosLoginVista(Usuario admin) {
        vistaLogin.datosLoginVista(admin);
    }

    @Override
    public void mostrarErrorPresenter(String error) {
        vistaLogin.mostrarErrorMain(error);
    }
}
