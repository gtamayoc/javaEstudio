package com.example.javaandroid.Presentador;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javaandroid.Modelo.MainModeloRegistrar;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.interfaces.InterfaceMain;

public class MainPresenterRegister implements InterfaceMain.PresenterRegistrar {

    InterfaceMain.VistaRegistrar vistaRegister;
    InterfaceMain.ModeloRegistrar modeloRegister;
    Usuario admin;
    Boolean valido;

    public MainPresenterRegister(InterfaceMain.VistaRegistrar vistaRegister, Context ctx, AppCompatActivity activity) {
        this.vistaRegister = vistaRegister;
        this.modeloRegister = new MainModeloRegistrar(MainPresenterRegister.this, ctx, activity);
        this.admin = admin;
    }

    @Override
    public void datosModelo(Usuario user) {
        String nombre = user.getNombre();
        String usuario = user.getUsuario();
        String clave = user.getClave();
        if(validarDatos(nombre,usuario,clave)){
            modeloRegister.consultarCredenciales(user);
        }else{
            mostrarErrorPresenter("No se pudo Registar al usuario, Datos incompletos");
        }
    }

    @Override
    public void datosLoginVista(Usuario admin) {

    }

    @Override
    public void mostrarErrorPresenter(String error) {
        vistaRegister.mostrarErrorMain(error);
    }

    private boolean validarDatos(String nombre, String usuario, String clave) {
        valido = false;
        if(nombre.isEmpty() || usuario.isEmpty() || clave.isEmpty()){
            mostrarErrorPresenter("Campos vacios");
            return valido;
        }
        if(nombre.length()<3 || usuario.length()<3 || clave.length()<3){
            mostrarErrorPresenter("Campos no cumplen un minimo de caracteres (3)");
            return valido;
        }
        valido = true;
        return valido;
    }


}
