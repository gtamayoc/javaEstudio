package com.example.javaandroid.Presentador;

import static com.example.javaandroid.Constantes.Constantes.EMPTY_FIELDS;
import static com.example.javaandroid.Constantes.Constantes.IMCOMPLETE_DATA;
import static com.example.javaandroid.Constantes.Constantes.NO_MINIMUM_CHARACTERS_FIELD;
import static com.example.javaandroid.Constantes.Constantes.VALID_FIELDS;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.example.javaandroid.Modelo.MainModeloRegistrar;
import com.example.javaandroid.Modelos.Usuario;
import com.example.javaandroid.interfaces.InterfaceMain;

public class MainPresenterRegister implements InterfaceMain.PresenterRegistrar {

    InterfaceMain.VistaRegistrar vistaRegister;
    InterfaceMain.ModeloRegistrar modeloRegister;
    Usuario admin;
    String valido;

    public MainPresenterRegister(InterfaceMain.VistaRegistrar vistaRegister, Context ctx, AppCompatActivity activity) {
        this.vistaRegister = vistaRegister;
        this.modeloRegister = new MainModeloRegistrar(MainPresenterRegister.this, ctx, activity);
        this.admin = admin;
    }

    @Override
    public void datosModelo(Usuario user) {
        String nombre = user.getNombre();
        String usuario = user.getUsuario();
        String clave = user.getClave();
        String opcion = validarDatos(nombre,usuario,clave);
        switch (opcion){
            case "0":
                break;
            case VALID_FIELDS:
                modeloRegister.consultarCredenciales(user);
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
    public void datosLoginVista(String response) {
        vistaRegister.datosLoginVista(response);
    }

    @Override
    public void mostrarErrorPresenter(String error) {
        vistaRegister.mostrarErrorMain(error);
    }

    @Override
    public void mostrarErrorDataBase(String error) {
        vistaRegister.mostrarErrorDataBase(error);
    }

    private String validarDatos(String nombre, String usuario, String clave) {
        if(nombre.isEmpty() || usuario.isEmpty() || clave.isEmpty()){
            return EMPTY_FIELDS;
        }
        if(nombre.length()<3 || usuario.length()<3 || clave.length()<3){
            return NO_MINIMUM_CHARACTERS_FIELD;
        }

        return VALID_FIELDS;
    }


}
