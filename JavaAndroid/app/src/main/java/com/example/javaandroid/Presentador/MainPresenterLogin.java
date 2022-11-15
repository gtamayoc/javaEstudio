package com.example.javaandroid.Presentador;

import static com.example.javaandroid.Constantes.Constantes.EMPTY_FIELDS;
import static com.example.javaandroid.Constantes.Constantes.NO_MINIMUM_CHARACTERS_FIELD;
import static com.example.javaandroid.Constantes.Constantes.VALID_FIELDS;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javaandroid.Modelo.MainModeloLogin;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.interfaces.InterfaceMain;

public class MainPresenterLogin implements InterfaceMain.PresenterLogin {

    InterfaceMain.VistaLogin vistaLogin;
    InterfaceMain.ModeloLogin modeloLogin;
    Usuario admin;

    public MainPresenterLogin(InterfaceMain.VistaLogin vistaLogin, Context ctx, AppCompatActivity activity) {
        this.vistaLogin = vistaLogin;
        this.modeloLogin = new MainModeloLogin(MainPresenterLogin.this, ctx, activity);
    }

    @Override
    public void datosLogin(String usuario, String clave) {
        String opcion = validarDatos(usuario,clave);
        switch (opcion){
            case "0":
                break;
            case VALID_FIELDS:
                modeloLogin.logearCredencialesAPI(usuario,clave);
                break;
            case EMPTY_FIELDS:
                mostrarErrorPresenter(EMPTY_FIELDS);
                break;
            case NO_MINIMUM_CHARACTERS_FIELD:
                mostrarErrorPresenter(NO_MINIMUM_CHARACTERS_FIELD);
                break;
            default:
                break;
        }

    }

    @Override
    public void datosLoginVista(Usuario admin) {
        vistaLogin.datosLoginVista(admin);
    }

    @Override
    public void mostrarErrorPresenter(String error) {
        vistaLogin.mostrarErrorMain(error);
    }

    @Override
    public String validarDatos(String user, String clave) {
            if(user.isEmpty() || clave.isEmpty()){
                return EMPTY_FIELDS;
            }
            if(user.length()<3 || clave.length()<3){
                return NO_MINIMUM_CHARACTERS_FIELD;
            }

            return VALID_FIELDS;
    }

    @Override
    public void mostrarErrorPresenterCampos(String error) {
        vistaLogin.mostrarErrorCampos(error);
    }
}
