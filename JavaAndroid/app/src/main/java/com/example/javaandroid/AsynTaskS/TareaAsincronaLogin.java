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

public class TareaAsincronaLogin extends AsyncTask<String, Void, String> {

    private Context ctx;
    private Usuario admin;
    private AppCompatActivity activity;
    public Intent intent;
    DataBase db;
    InterfaceMain.PresenterLogin presenterLogin;
    InterfaceMain.PresenterRegistrar presenterRegistrar;
    loginListener listener;

    public TareaAsincronaLogin(AppCompatActivity activity, Context ctx, InterfaceMain.PresenterLogin presenterLogin, Usuario admin, loginListener listener) {
        this.ctx = ctx;
        this.admin = admin;
        this.activity = activity;
        this.presenterLogin = presenterLogin;
        this.listener = listener;
    }

    public TareaAsincronaLogin(AppCompatActivity activity, Context ctx, InterfaceMain.PresenterRegistrar presenterRegistrar, Usuario admin) {
        this.ctx = ctx;
        this.admin = admin;
        this.activity = activity;
        this.presenterRegistrar = presenterRegistrar;
    }

    public interface loginListener{
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
        try {
            Thread.sleep(2000);
            db = Room.databaseBuilder(ctx.getApplicationContext(),
                    DataBase.class, "javaAndroid").build();
            UserDAO userDao = db.userDao();
            List<UserEntity> users = userDao.loadUserByUserName("123");
            String opcion = strings[0];
            switch (opcion){
                case "0":

                    break;
                case "1":
                    if(!users.isEmpty()){
                        return "No se encontro al usuario";
                    }
                    if(strings[1].equals(userDB) && strings[2].equals(passwordDB)){
                        admin = new Usuario("Giuseppe");
                        admin.setUsuario(strings[1]);
                        admin.setClave(strings[2]);
                        return "Usuario Existe";
                    }else{
                        presenterLogin.mostrarErrorPresenter("Datos No Validos");
                    }
                    for(UserEntity userList : users)
                    {
                        Toast.makeText(ctx, "Prueba", Toast.LENGTH_SHORT).show();
                    }
                    presenterLogin.mostrarErrorPresenterCampos("Datos No Validos");
                    break;
                case "2":

                    break;
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
                iniciarActivity();
                break;
            case "2":

                break;
            default:
                presenterLogin.mostrarErrorPresenter("ERROR INESPERADO");
                break;
        }

    }


    public void iniciarActivity(){
        intent = new Intent(activity.getApplicationContext(), StartActivity.class);
        intent.putExtra("Usuario", admin);
        activity.startActivity(intent);
    }
}
