package com.example.javaandroid.Modelos;

import java.io.Serializable;

public class Usuario implements Serializable {

    public String nombre;
    public String usuario;
    public String clave;

    public Usuario() {

    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }



}
