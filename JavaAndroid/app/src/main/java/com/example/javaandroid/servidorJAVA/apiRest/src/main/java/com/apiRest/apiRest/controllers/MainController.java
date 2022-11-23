package com.apiRest.apiRest.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiRest.apiRest.models.UsuarioModel;
import com.apiRest.apiRest.services.UsuarioService;

@RestController
@RequestMapping("/")
public class MainController {
    
    @Autowired
    UsuarioService usuarioService;
    ArrayList<UsuarioModel> users;
    
    @GetMapping("/")
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        users = this.usuarioService.ObtenerUsuarios();
        return users;
    }




}
