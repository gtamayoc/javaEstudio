package com.example.javaandroid.Modelo;

import static com.example.javaandroid.Constantes.Constantes.passwordDB;
import static com.example.javaandroid.Constantes.Constantes.userDB;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javaandroid.AsynTaskS.TareaAsincronaLogin;
import com.example.javaandroid.DataBase.DataBase;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.Presentador.MainPresenterRegister;
import com.example.javaandroid.interfaces.InterfaceMain;

public class MainModeloRegistrar implements InterfaceMain.ModeloRegistrar {

    InterfaceMain.PresenterRegistrar mainPresenterRegister;
    Context ctx;
    Usuario admin;
    AppCompatActivity activity;
    DataBase db;
    TareaAsincronaLogin asyncTask;

    public MainModeloRegistrar(InterfaceMain.PresenterRegistrar mainPresenterRegister, Context ctx, AppCompatActivity activity) {
        this.mainPresenterRegister = mainPresenterRegister;
        this.ctx = ctx;
        this.activity = activity;
    }

    @Override
    public void consultarCredenciales(Usuario user) {
        asyncTask = new TareaAsincronaLogin(activity ,ctx, mainPresenterRegister, admin);
        asyncTask.execute("1","giuseppe");
        if(user.getUsuario().equals(userDB) && user.getClave().equals(passwordDB)){
            admin = new Usuario("Giuseppe");
            admin.setUsuario(user.usuario);
            admin.setClave(user.getClave());
            mainPresenterRegister.datosLoginVista(admin);

        }else{
            mainPresenterRegister.mostrarErrorPresenter("Datos No Validos");
        }


    }
}
