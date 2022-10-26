package com.example.javaandroid.Modelo;

import static com.example.javaandroid.Constantes.Constantes.passwordDB;
import static com.example.javaandroid.Constantes.Constantes.userDB;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javaandroid.AsynTaskS.TareaAsincronaLogin;
import com.example.javaandroid.DataBase.DataBase;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.Presentador.MainPresenterLogin;
import com.example.javaandroid.interfaces.InterfaceMain;

public class MainModeloLogin implements InterfaceMain.ModeloLogin {

    InterfaceMain.PresenterLogin presenterLogin;
    Context ctx;
    Usuario admin;
    DataBase db;
    AppCompatActivity activity;
    TareaAsincronaLogin asyncTask;

    public MainModeloLogin(MainPresenterLogin mainPresenter, Context ctx, AppCompatActivity activity) {
        this.presenterLogin = mainPresenter;
        this.ctx = ctx;
        this.activity = activity;
    }

    @Override
    public void logearCredenciales(String user, String password) {
        asyncTask = new TareaAsincronaLogin(activity ,ctx, presenterLogin, admin);
        asyncTask.execute("giuseppe");
        if(user.equals(userDB) && password.equals(passwordDB)){
                admin = new Usuario("Giuseppe");
                admin.setUsuario(user);
                admin.setClave(password);
                presenterLogin.datosLoginVista(admin);

        }else{
            presenterLogin.mostrarErrorPresenter("Datos No Validos");
        }
    }
}
