package com.apiRest.apiRest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiRest.apiRest.models.UsuarioModel;
import com.apiRest.apiRest.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuarios(){
        return this.usuarioService.ObtenerUsuarios();
    }

    @PostMapping()
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuario){
        //return "{\"message\": \"OK\"}"+ usuario.getId() + " " + usuario.getEmail()+ " " + usuario.getNombre();
        return this.usuarioService.guardarUsuario(usuario);
    }

    @GetMapping ( path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping ( "/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad){
        return this.usuarioService.obtenerPorPrioridad(prioridad);
    }

    @DeleteMapping ( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        Boolean ok = this.usuarioService.eliminarUsuario(id);
        if(ok){
            return "Se Elimino Usuario Con Id : "+ id;
        }else{
            return "No Se Pudo Eliminar Usuario Con Id : "+ id;
        }
    }

}
