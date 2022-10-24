package com.example.javaandroid.interfaces;

import com.example.javaandroid.Modelos.Usuario;

public interface InterfaceMain {

    interface Presenter{
        void datosLogin(String usuario, String clave);

        void datosLoginVista(Usuario admin);
        void mostrarErrorPresenter(String error);
    }

    interface Vista{
        void datosLogin(String user, String password);
        void datosLoginVista(Usuario admin);

        void mostrarErrorMain(String error);
    }

    interface Modelo{
        void logearCredenciales(String user, String password);
    }
}
