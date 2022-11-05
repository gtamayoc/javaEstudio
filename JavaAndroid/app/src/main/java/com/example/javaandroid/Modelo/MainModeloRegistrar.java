package com.example.javaandroid.Modelo;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javaandroid.AsynTaskS.TareaAsincronaLogin;
import com.example.javaandroid.DataBase.DataBase;
import com.example.javaandroid.Modelos.Usuario;
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
        asyncTask = new TareaAsincronaLogin(activity, ctx, mainPresenterRegister, admin, new TareaAsincronaLogin.registerListener() {
            @Override
            public void response(String response) {
                mainPresenterRegister.datosLoginVista(response);
            }

            @Override
            public void error(String error, String user) {
                mainPresenterRegister.mostrarErrorPresenter(error);
                mainPresenterRegister.mostrarErrorDataBase(user);
            }
        });

        asyncTask.execute("2",user.getUsuario(),user.getClave(),user.getNombre());

    }
}
