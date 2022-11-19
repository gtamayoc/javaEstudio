package com.example.javaandroid.Modelo;

import static com.example.javaandroid.Constantes.Constantes.API_KEY;
import static com.example.javaandroid.Constantes.Constantes.USER_CREDENTIALS;
import static com.example.javaandroid.Constantes.Constantes.USER_VALID;

import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javaandroid.API.EstudioApi;
import com.example.javaandroid.API.Service;
import com.example.javaandroid.API.responses.LoginResponse;
import com.example.javaandroid.AsynTaskS.TareaAsincronaLogin;
import com.example.javaandroid.DataBase.DataBase;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.interfaces.InterfaceMain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainModeloLogin implements InterfaceMain.ModeloLogin {

    InterfaceMain.PresenterLogin presenterLogin;
    Context ctx;
    Usuario admin;
    DataBase db;
    AppCompatActivity activity;
    TareaAsincronaLogin asyncTask;

    public MainModeloLogin(InterfaceMain.PresenterLogin mainPresenter, Context ctx, AppCompatActivity activity) {
        this.presenterLogin = mainPresenter;
        this.ctx = ctx;
        this.activity = activity;
    }

    @Override
    public void logearCredenciales(String user, String password) {
        asyncTask = new TareaAsincronaLogin(activity, ctx, presenterLogin, admin, new TareaAsincronaLogin.loginListener() {

            @Override
            public void response(Usuario admin) {
                presenterLogin.datosLoginVista(admin);
            }

            @Override
            public void error(String error) {
                presenterLogin.mostrarErrorPresenter(error);
            }
        });

        asyncTask.execute("1",user,password);
    }
    public static String dateTime(){
        Calendar c = Calendar.getInstance();
        Date date = c.getTime(); //current date and time in UTC
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSS");
        df.setTimeZone(TimeZone.getTimeZone("GMT+5:00")); //format in given timezone
        String strDate = df.format(date);
        return strDate;
    }

    @Override
    public void logearCredencialesAPI(String user, String password) {
        String datee = dateTime();
        Log.e("TAG1", "Model  " + datee );
        EstudioApi movieApi = Service.getEstudioApi();
        Call<LoginResponse> responseCall = movieApi.loginPass2(user, password);
        responseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.code() == 200) {
                    String responses = response.body().getToken();
                    String user2 = response.body().getUser();
                    String pass2 = response.body().getPass();
                    String tkn2 = response.body().getToken();
                    String messagge = response.body().getMessage();
                    try {
                        if(messagge.equals(USER_VALID)){
                            if(tkn2.equals(API_KEY))
                            {
                                Log.e("TAG1", "Model  " + user2 + " " + pass2 + " " + tkn2 + " " + messagge);
                                presenterLogin.datosLoginVista(admin);
                            }else{
                                Log.e("TAG1", "message  " + messagge);
                                presenterLogin.mostrarErrorPresenter(messagge);
                            }
                        }
                        else
                        {
                            Log.e("TAG1", "message  " + messagge);
                            presenterLogin.mostrarErrorPresenter(messagge);
                        }

                    } catch (Exception e) {
                        Log.e("TAG1-ERRO1", "the response " + response.code());
                    }
                } else {
                    Log.e("TAG2-ERRO1", "hay un error en la descarga del recurso : " + response.code());
                    Log.w("LOGIN-LOCAL", "Error en API, Acceso mediante Login local ");
                    logearCredenciales(user,password);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }
}
