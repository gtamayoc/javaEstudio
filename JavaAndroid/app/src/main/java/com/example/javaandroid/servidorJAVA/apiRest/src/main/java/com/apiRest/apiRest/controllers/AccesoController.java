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

import com.apiRest.apiRest.models.Acceso;
import com.apiRest.apiRest.models.AccesoModel;
import com.apiRest.apiRest.services.AccesoService;

@RestController
@RequestMapping("/acceso")
public class AccesoController {
    
    @Autowired
    AccesoService accesoService;
    AccesoModel accesoModel;

    @GetMapping()
    public ArrayList<AccesoModel> getAll(){
        return this.accesoService.getAll();
    }

   // @PostMapping()
   // public AccesoModel guardarUsuario(@RequestBody AccesoModel accesoModel){
    //    return this.accesoService.guardarAcceso(accesoModel);
    //}

    @PostMapping()
    public String guardarUsuario(@RequestBody Acceso acces){
        return "{\"message\": \"OK\"}"+ accesoModel.getId()+ " " + accesoModel.getUsuarioModelId();
        //return this.accesoService.guardarAcceso(accesoModel);
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
