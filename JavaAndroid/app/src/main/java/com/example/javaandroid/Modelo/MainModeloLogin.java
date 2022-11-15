package com.example.javaandroid.Modelo;

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

    @Override
    public void logearCredencialesAPI(String user, String password) {
        EstudioApi movieApi = Service.getEstudioApi();
        Call<LoginResponse> responseCall = movieApi.loginPass1(user, password);
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
                            Log.e("TAG1", "Model  " + user2 + " " + pass2 + " " + tkn2 + " " + messagge);
                            presenterLogin.datosLoginVista(admin);
                        }else
                        {
                            Log.e("TAG1", "Model  " + user2 + " " + pass2 + " " + tkn2 + " " + messagge);
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
