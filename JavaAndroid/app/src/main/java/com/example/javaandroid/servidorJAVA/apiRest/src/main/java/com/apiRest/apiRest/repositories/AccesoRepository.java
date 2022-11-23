package com.apiRest.apiRest.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apiRest.apiRest.models.AccesoModel;

@Repository
public interface AccesoRepository extends CrudRepository<AccesoModel, Long> {
    
}
