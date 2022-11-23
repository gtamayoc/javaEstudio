package com.apiRest.apiRest.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiRest.apiRest.models.AccesoModel;
import com.apiRest.apiRest.repositories.AccesoRepository;

@Service
public class AccesoService {

    @Autowired
    AccesoRepository accesoRepository;

    public ArrayList<AccesoModel> getAll(){
        return (ArrayList<AccesoModel>) accesoRepository.findAll();
    }

    public AccesoModel guardarAcceso(AccesoModel acceso){
        return accesoRepository.save(acceso);
    }

    /*public ArrayList<AccesoModel> guardarAcceso2(Long id){
        return accesoRepository.save(id);
    }*/

    public Optional<AccesoModel> obtenerPorId(Long id){
        return accesoRepository.findById(id);
    }

    public ArrayList<AccesoModel> obtenerPorUserId(Long id){
        return accesoRepository.findByIdUsuarioModelId(id);
    }
}
