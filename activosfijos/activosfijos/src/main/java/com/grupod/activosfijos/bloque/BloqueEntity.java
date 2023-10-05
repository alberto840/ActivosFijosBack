package com.grupod.activosfijos.bloque;

import jakarta.persistence.*;

@Entity
@Table
public class BloqueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_bloque;
    private String bloque_nombre;
    private Integer departamento_id_departamento;

    //Constructor vacio
    public BloqueEntity() {
    }

    //Constructor lleno
    public BloqueEntity(Integer id_bloque, String bloque_nombre, Integer departamento_id_departamento) {
        this.id_bloque = id_bloque;
        this.bloque_nombre = bloque_nombre;
        this.departamento_id_departamento = departamento_id_departamento;
    }

    //Getters y setters
    public Integer getId_bloque() {
        return id_bloque;
    }
    public void setId_bloque(Integer id_bloque) {
        this.id_bloque = id_bloque;
    }
    public String getBloque_nombre() {
        return bloque_nombre;
    }
    public void setBloque_nombre(String bloque_nombre) {
        this.bloque_nombre = bloque_nombre;
    }
    public Integer getDepartamento_id_departamento() {
        return departamento_id_departamento;
    }
    public void setDepartamento_id_departamento(Integer departamento_id_departamento) {
        this.departamento_id_departamento = departamento_id_departamento;
    }

    
}
