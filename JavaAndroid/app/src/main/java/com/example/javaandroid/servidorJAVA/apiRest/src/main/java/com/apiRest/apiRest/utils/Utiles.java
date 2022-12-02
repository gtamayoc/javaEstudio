package com.apiRest.apiRest.utils;

import java.util.ArrayList;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    public static UsuarioModel generarToken(UsuarioModel users){
        UsuarioModel tokenUser = users;
        String passTokenizada = new BCryptPasswordEncoder().encode(users.getPassword());
        tokenUser.setPassword(passTokenizada);
        return tokenUser;
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
