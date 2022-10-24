package com.example.javaandroid.AsynTaskS;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javaandroid.DataBase.DataBase;
import com.example.javaandroid.DataBase.UserDAO;
import com.example.javaandroid.DataBase.UserEntity;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.R;
import com.example.javaandroid.Vista.StartActivity;
import com.example.javaandroid.interfaces.InterfaceMain;

import java.util.List;
import java.util.Map;

public class TareaAsincronaLogin extends AsyncTask<String, Void, String> {

    private Context ctx;
    private Usuario admin;
    private AppCompatActivity activity;
    public Intent intent;
    DataBase db;
    InterfaceMain.Presenter presenter;

    public TareaAsincronaLogin(AppCompatActivity activity, Context ctx, InterfaceMain.Presenter presenter, Usuario admin) {
        this.ctx = ctx;
        this.admin = admin;
        this.activity = activity;
        this.presenter = presenter;
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
            List<UserEntity> users = userDao.loadUserByUserName("1233");
            if(users.isEmpty()){
                presenter.mostrarErrorPresenter("Datos Incorrectos");
                return "fallo1";
            }
            for(UserEntity userList : users)
            {

            }
        }catch (Exception e){e.printStackTrace();}
        return "fallo2";
    }

    @Override
    protected void onPostExecute(String s) {
        activity.findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
        Toast.makeText(activity, "Se logro "+s, Toast.LENGTH_SHORT).show();
        if(s.equals("fallo1")){

        }else if (s.equals("fallo2")){

        }else{
            iniciarActivity();
        }

    }


    public void iniciarActivity(){
        intent = new Intent(activity.getApplicationContext(), StartActivity.class);
        intent.putExtra("Usuario", admin);
        activity.startActivity(intent);
    }
}
