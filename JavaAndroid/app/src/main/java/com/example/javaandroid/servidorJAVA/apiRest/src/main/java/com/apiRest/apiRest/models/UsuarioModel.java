package com.apiRest.apiRest.models;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint(name = "uc_email", columnNames={"email_usua"})})
public class UsuarioModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    
    @Column(nullable = false, name = "nombre_usua")
    private String nombre;
    @Column(name = "email_usua", nullable = false)
    private String email;
    @Column(name = "password_usua", nullable = false)
    private String password;
    @Column(nullable = false, name = "prioridad_usua")
    private Integer pro;

    @OneToOne(mappedBy = "usuarioModelId", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AccesoModel accesoModel;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPro(Integer pro) {
        this.pro = pro;
    }
    public Integer getPro() {
        return pro;
    }

}
