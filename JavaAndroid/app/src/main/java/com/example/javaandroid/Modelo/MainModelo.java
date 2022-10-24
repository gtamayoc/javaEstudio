package com.example.javaandroid.Modelo;

import static com.example.javaandroid.Constantes.Constantes.passwordDB;
import static com.example.javaandroid.Constantes.Constantes.userDB;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.javaandroid.AsynTaskS.TareaAsincronaLogin;
import com.example.javaandroid.DataBase.DataBase;
import com.example.javaandroid.DataBase.UserDAO;
import com.example.javaandroid.DataBase.UserEntity;
import com.example.javaandroid.MainActivity;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.Presentador.MainPresenter;
import com.example.javaandroid.interfaces.InterfaceMain;

import java.util.List;

public class MainModelo implements InterfaceMain.Modelo {

    InterfaceMain.Presenter presenter;
    Context ctx;
    Usuario admin;
    DataBase db;
    AppCompatActivity activity;
    TareaAsincronaLogin asyncTask;

    public MainModelo(MainPresenter mainPresenter, Context ctx, AppCompatActivity activity) {
        this.presenter = mainPresenter;
        this.ctx = ctx;
        this.activity = activity;
    }

    @Override
    public void logearCredenciales(String user, String password) {
        asyncTask = new TareaAsincronaLogin(activity ,ctx, presenter, admin);
        asyncTask.execute("giuseppe");
        if(user.equals(userDB) && password.equals(passwordDB)){
                admin = new Usuario("Giuseppe");
                admin.setUsuario(user);
                admin.setClave(password);
                presenter.datosLoginVista(admin);

        }else{
            presenter.mostrarErrorPresenter("Datos No Validos");
        }
    }
}
