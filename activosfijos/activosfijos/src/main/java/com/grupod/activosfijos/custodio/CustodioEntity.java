package com.grupod.activosfijos.custodio;

import jakarta.persistence.*;

@Entity
@Table
public class CustodioEntity {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_custodio;
    private String custodio_nombre;
    private String custodio_apellido_paterno;
    private String custodio_apellido_materno;
    private String custodio_telefono;
    private String custodio_correo;
    private Integer custodio_estado;

    //Constructor lleno
    public CustodioEntity(Integer id_custodio, String custodio_nombre, String custodio_apellido_paterno,
            String custodio_apellido_materno, String custodio_telefono, String custodio_correo,
            Integer custodio_estado) {
        this.id_custodio = id_custodio;
        this.custodio_nombre = custodio_nombre;
        this.custodio_apellido_paterno = custodio_apellido_paterno;
        this.custodio_apellido_materno = custodio_apellido_materno;
        this.custodio_telefono = custodio_telefono;
        this.custodio_correo = custodio_correo;
        this.custodio_estado = custodio_estado;
    }

    //Constructor vacio
    public CustodioEntity() {
    }
    
    //Getters y setters
    public Integer getId_custodio() {
        return id_custodio;
    }
    public void setId_custodio(Integer id_custodio) {
        this.id_custodio = id_custodio;
    }
    public String getCustodio_nombre() {
        return custodio_nombre;
    }
    public void setCustodio_nombre(String custodio_nombre) {
        this.custodio_nombre = custodio_nombre;
    }
    public String getCustodio_apellido_paterno() {
        return custodio_apellido_paterno;
    }
    public void setCustodio_apellido_paterno(String custodio_apellido_paterno) {
        this.custodio_apellido_paterno = custodio_apellido_paterno;
    }
    public String getCustodio_apellido_materno() {
        return custodio_apellido_materno;
    }
    public void setCustodio_apellido_materno(String custodio_apellido_materno) {
        this.custodio_apellido_materno = custodio_apellido_materno;
    }
    public String getCustodio_telefono() {
        return custodio_telefono;
    }
    public void setCustodio_telefono(String custodio_telefono) {
        this.custodio_telefono = custodio_telefono;
    }
    public String getCustodio_correo() {
        return custodio_correo;
    }
    public void setCustodio_correo(String custodio_correo) {
        this.custodio_correo = custodio_correo;
    }
    public Integer getCustodio_estado() {
        return custodio_estado;
    }
    public void setCustodio_estado(Integer custodio_estado) {
        this.custodio_estado = custodio_estado;
    }

}
