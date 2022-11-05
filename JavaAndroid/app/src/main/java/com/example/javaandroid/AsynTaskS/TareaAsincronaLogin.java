package com.example.javaandroid.AsynTaskS;

import static com.example.javaandroid.Constantes.Constantes.USERNAME_REGISTERED;
import static com.example.javaandroid.Constantes.Constantes.USER_ALREADY_REGISTERED;
import static com.example.javaandroid.Constantes.Constantes.USER_CREDENTIALS;
import static com.example.javaandroid.Constantes.Constantes.USER_EMPTY;
import static com.example.javaandroid.Constantes.Constantes.USER_EXITS;
import static com.example.javaandroid.Constantes.Constantes.USER_REGISTERED;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.view.View;
import android.widget.Toast;

import com.example.javaandroid.DataBase.DataBase;
import com.example.javaandroid.DataBase.DAO.UserDAO;
import com.example.javaandroid.DataBase.Entitys.AccesoEntity;
import com.example.javaandroid.DataBase.Entitys.UserAndAcceso;
import com.example.javaandroid.DataBase.Entitys.UserEntity;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.R;
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
    loginListener listenerLogin;
    registerListener listenerRegister;

    public TareaAsincronaLogin(AppCompatActivity activity, Context ctx, InterfaceMain.PresenterLogin presenterLogin, Usuario admin, loginListener listenerLogin) {
        this.ctx = ctx;
        this.admin = admin;
        this.activity = activity;
        this.presenterLogin = presenterLogin;
        this.listenerLogin = listenerLogin;
    }

    public TareaAsincronaLogin(AppCompatActivity activity, Context ctx, InterfaceMain.PresenterRegistrar presenterRegistrar, Usuario admin, registerListener listenerLogin) {
        this.ctx = ctx;
        this.admin = admin;
        this.activity = activity;
        this.presenterRegistrar = presenterRegistrar;
        this.listenerRegister = listenerLogin;
    }

    public interface loginListener{
        void response(Usuario admin);
        void error(String error);
    }

    public interface registerListener{
        void response(String response);
        void error(String error, String user);
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
        db = DataBase.getInstance(ctx);
        UserDAO userDao = db.userDao();
        try {
            Thread.sleep(1000);
            List<UserEntity> users = userDao.loadUserByUserName(strings[1]);
            List<UserAndAcceso> getUserAndAcceso = userDao.getUserAndAcceso(strings[1], strings[2]);
            String opcion = strings[0];
            switch (opcion){
                case "0":

                    break;
                case "1":
                    if(users.isEmpty()){
                        return USER_EMPTY;
                    }
                    for(UserEntity userList : users)
                    {
                        if(strings[1].equals(userList.userName) && strings[2].equals(userList.password)){
                            admin = new Usuario(userList.firstName);
                            admin.setUsuario(strings[1]);
                            admin.setClave(strings[2]);
                            return USER_EXITS;
                        }else
                            return USER_CREDENTIALS;
                    }
                    break;
                case "2":
                    if(users.isEmpty()){
                        UserEntity userR = new UserEntity();
                        AccesoEntity accesR = new AccesoEntity();
                        String uuidUser = UUID.randomUUID().toString();
                        String uuidAcces = UUID.randomUUID().toString();
                        userR.setUserName(strings[1]);
                        userR.setPassword(strings[2]);
                        userR.setFirstName(strings[3]);
                        accesR.setUid(userR.getUid());
                        accesR.setAid(uuidAcces);
                        userDao.insertAll(userR);
                        userDao.insertAllAcceso(accesR);
                        return USER_REGISTERED;
                    }else{
                        return USER_ALREADY_REGISTERED;
                    }

                default:
                    break;
            }

            return strings[0];
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();}
        return "fallo2";
    }

    @Override
    protected void onPostExecute(String s) {
        activity.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
        switch (s){
            case USER_EMPTY:
                listenerLogin.error(USER_EMPTY);
                break;
            case USER_EXITS:
                listenerLogin.response(admin);
                break;
            case USER_CREDENTIALS:
                listenerLogin.error(USER_CREDENTIALS);
                break;
            case USER_REGISTERED:
                listenerRegister.response(USER_REGISTERED);
                break;
            case USER_ALREADY_REGISTERED:
                listenerRegister.error(USER_ALREADY_REGISTERED,USERNAME_REGISTERED);
                break;
            case "fallo2":
                presenterLogin.mostrarErrorPresenter("Datos No Validos");
                break;
            default:
                break;
        }

    }

}
