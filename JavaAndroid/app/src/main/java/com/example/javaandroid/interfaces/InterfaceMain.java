package com.example.javaandroid.interfaces;

import com.example.javaandroid.Modelos.Usuario;

public interface InterfaceMain {

    interface PresenterLogin {
        void datosLogin(String usuario, String clave);

        void datosLoginVista(Usuario admin);
        void mostrarErrorPresenter(String error);
        String validarDatos(String user, String clave);

        void mostrarErrorPresenterCampos(String error);
    }

    interface VistaLogin {
        void datosLogin(String user, String password);
        void datosLoginVista(Usuario admin);

        void mostrarErrorMain(String error);
        void mostrarErrorCampos(String error);
    }

    interface ModeloLogin {
        void logearCredenciales(String user, String password);
        void logearCredencialesAPI(String user, String password);
    }

    interface PresenterRegistrar{
        void datosModelo(Usuario user);

        void datosLoginVista(String response);
        void mostrarErrorPresenter(String error);
        void mostrarErrorDataBase(String error);
    }

    interface VistaRegistrar{
        void datosVista(Usuario user);
        void datosLoginVista(String response);

        void mostrarErrorMain(String error);
        void mostrarErrorDataBase(String error);
    }

    interface ModeloRegistrar{
        void consultarCredenciales(Usuario user);
    }


}
