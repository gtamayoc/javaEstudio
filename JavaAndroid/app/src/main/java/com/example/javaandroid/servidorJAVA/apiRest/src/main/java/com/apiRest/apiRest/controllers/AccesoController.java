package com.apiRest.apiRest.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiRest.apiRest.models.AccesoModel;
import com.apiRest.apiRest.models.UsuarioModel;
import com.apiRest.apiRest.services.AccesoService;
import com.apiRest.apiRest.services.UsuarioService;
import com.apiRest.apiRest.utils.Utiles;

@RestController
@RequestMapping("/acceso")
public class AccesoController {
    
    @Autowired
    AccesoService accesoService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<AccesoModel> getAll(){
        return this.accesoService.getAll();
    }

   // @PostMapping()
   // public AccesoModel guardarUsuario(@RequestBody AccesoModel accesoModel){
    //    return this.accesoService.guardarAcceso(accesoModel);
    //}

    @PostMapping()
    public AccesoModel guardarUsuario(@RequestBody AccesoModel accesoModel){
        ArrayList<AccesoModel> accesoModels = this.accesoService.getAll();
        if(Utiles.validarUsuarios(accesoModels, accesoModel.getUsuarioModelId())){
            return new AccesoModel();
        }
        ArrayList<UsuarioModel> usuarios = this.usuarioService.ObtenerUsuarios();
        if(!Utiles.validarUsuariosId(usuarios, accesoModel.getUsuarioModelId())){
            return new AccesoModel();
        }
        //return "{\"message\": \"OK\"}"+ accesoModel.getId() + " " + accesoModel.getUsuarioModelId();
        return this.accesoService.guardarAcceso(accesoModel);
    }
    
    /*@PostMapping()
    public String guardarAcceso(@RequestBody AccesoModel accesoModel){
        Long id = (long) 12;
        return "{\"message\": \"OK\"}"+ accesoModel.getId() + " " + accesoModel.getId_usuario();
    }
*/
    @GetMapping ( path = "/{id}")
    public Optional<AccesoModel> obtenerUsuarioPorId(@PathVariable("id") Long id){
        return this.accesoService.obtenerPorId(id);
    }

}
