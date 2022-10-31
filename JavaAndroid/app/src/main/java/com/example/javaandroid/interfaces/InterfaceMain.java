package com.example.javaandroid.interfaces;

import com.example.javaandroid.Modelos.Usuario;

public interface InterfaceMain {

    interface PresenterLogin {
        void datosLogin(String usuario, String clave);

        void datosLoginVista(Usuario admin);
        void mostrarErrorPresenter(String error);

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
    }

    interface PresenterRegistrar{
        void datosModelo(Usuario user);

        void datosLoginVista(Usuario admin);
        void mostrarErrorPresenter(String error);
    }

    interface VistaRegistrar{
        void datosVista(Usuario user);
        void datosLoginVista(Usuario admin);

        void mostrarErrorMain(String error);
    }

    interface ModeloRegistrar{
        void consultarCredenciales(Usuario user);
    }


}
