package com.apiRest.apiRest.models;

public class Acceso {
    public Long id_usuario;

    public Acceso(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

}