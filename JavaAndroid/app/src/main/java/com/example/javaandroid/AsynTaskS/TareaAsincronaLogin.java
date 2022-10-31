package com.example.javaandroid.AsynTaskS;

import static com.example.javaandroid.Constantes.Constantes.passwordDB;
import static com.example.javaandroid.Constantes.Constantes.userDB;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.view.View;
import android.widget.Toast;

import com.example.javaandroid.DataBase.DataBase;
import com.example.javaandroid.DataBase.UserDAO;
import com.example.javaandroid.DataBase.UserEntity;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.Presentador.MainPresenterLogin;
import com.example.javaandroid.R;
import com.example.javaandroid.Vista.StartActivity;
import com.example.javaandroid.interfaces.InterfaceMain;

import java.util.List;
import java.util.UUID;

public class TareaAsincronaLogin extends AsyncTask<String, Void, String> {

    private Context ctx;
    private Usuario admin;
    private AppCompatActivity activity;
    public Intent intent;
    DataBase db;
    InterfaceMain.PresenterLogin presenterLogin;
    InterfaceMain.PresenterRegistrar presenterRegistrar;
    loginListener listener;
    registerListener listener1;

    public TareaAsincronaLogin(AppCompatActivity activity, Context ctx, InterfaceMain.PresenterLogin presenterLogin, Usuario admin, loginListener listener) {
        this.ctx = ctx;
        this.admin = admin;
        this.activity = activity;
        this.presenterLogin = presenterLogin;
        this.listener = listener;
    }

    public TareaAsincronaLogin(AppCompatActivity activity, Context ctx, InterfaceMain.PresenterRegistrar presenterRegistrar, Usuario admin, registerListener listener) {
        this.ctx = ctx;
        this.admin = admin;
        this.activity = activity;
        this.presenterRegistrar = presenterRegistrar;
        this.listener1 = listener;
    }

    public interface loginListener{
        void response(String response);
        void error(String error);
    }

    public interface registerListener{
        void response(String response);
        void error(String error);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
        Toast.makeText(ctx, "Prueba", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPreExecute() {
        activity.findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(String... strings) {
        db = Room.databaseBuilder(ctx.getApplicationContext(),
                DataBase.class, "javaAndroid").build();
        UserDAO userDao = db.userDao();
        try {
            Thread.sleep(2000);
            List<UserEntity> users = userDao.loadUserByUserName(strings[2]);
            String opcion = strings[0];
            switch (opcion){
                case "0":

                    break;
                case "1":
                    if(users.isEmpty()){
                        listener.error("No se encontro al usuario");
                        return "No se encontro al usuario";
                    }
                    for(UserEntity userList : users)
                    {
                        if(strings[1].equals(userList.userName) && strings[2].equals(userList.password)){
                            admin = new Usuario(userList.firstName);
                            admin.setUsuario(strings[1]);
                            admin.setClave(strings[2]);
                            return "Usuario Existe";
                        }
                    }
                    return "Error, Usuario o Clave no validos";
                case "2":
                    if(users.isEmpty()){
                        UserEntity userR = new UserEntity();
                        String UUIDUser= UUID.randomUUID().toString();
                        userR.setUid(UUIDUser);
                        userR.setFirstName(strings[1]);
                        userR.setUserName(strings[2]);
                        userR.setPassword(strings[3]);
                        userDao.insertAll(userR);
                        return "Usuario Registrado";
                    }else{
                        return "Usuario Ya Registrado";
                    }

                default:
                    break;
            }

            return strings[0];
        }catch (Exception e){e.printStackTrace();}
        return "fallo2";
    }

    @Override
    protected void onPostExecute(String s) {
        activity.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
        switch (s){
            case "No se encontro al usuario":
                presenterLogin.mostrarErrorPresenter(""+s);
                break;
            case "Usuario Existe":
                presenterLogin.datosLoginVista(admin);
                break;
            case "Datos No Validos":
                presenterLogin.mostrarErrorPresenter("Datos No Validos");
                break;
            case "Datos En Campos No Validos":
                presenterLogin.mostrarErrorPresenterCampos("Datos No Validos");
                break;
            case "Usuario Registrado":
                presenterRegistrar.mostrarErrorPresenter("Usuario Registrado");
                break;
            case "Usuario Ya Registrado":
                presenterRegistrar.mostrarErrorPresenter("Usuario Ya Registrado");
                break;
            default:

                break;
        }

    }

}
