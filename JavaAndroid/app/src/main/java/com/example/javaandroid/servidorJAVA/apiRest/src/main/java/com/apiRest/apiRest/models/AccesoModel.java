package com.apiRest.apiRest.models;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Table(name = "acceso", uniqueConstraints = {@UniqueConstraint(name = "uc_acceso", columnNames={"id","id_usuario"})})
public class AccesoModel implements Serializable{

    public AccesoModel() {
         
    }

    public AccesoModel(Acceso acceso) {
        this.usuarioModelId.setId(acceso.getId_usuario());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_id_usuario"), nullable = false)
    private UsuarioModel usuarioModelId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    } 

    @JsonProperty("id_usuario")
    public Long getUsuarioModelId() {
        return this.usuarioModelId.getId();
    }
 
    public void setUsuarioModelId(Long id) {
        this.usuarioModelId.setId(id);
    }

    

}


