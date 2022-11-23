package com.apiRest.apiRest.utils;

import java.util.ArrayList;

import com.apiRest.apiRest.models.AccesoModel;
import com.apiRest.apiRest.models.UsuarioModel;

public class Utiles {
    
    public Utiles() {
    }

    public static Boolean validarCorreos(ArrayList<UsuarioModel> users, String correo){
        for (UsuarioModel user : users) {
            if(user.getEmail().equals(correo)){
                return true;
            }
        }
        return false;
    }

    public static Boolean validarUsuarios(ArrayList<AccesoModel> accesos, Long id){
        for (AccesoModel acceso : accesos) {
            if(acceso.getUsuarioModelId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public static Boolean validarUsuariosId(ArrayList<UsuarioModel> users, Long id){
        for (UsuarioModel user : users) {
            if(user.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

}
