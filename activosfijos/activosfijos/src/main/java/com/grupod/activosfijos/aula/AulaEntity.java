package com.grupod.activosfijos.aula;

import jakarta.persistence.*;

@Entity
@Table
public class AulaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_aula;
    private String aula_nombre;
    private Integer bloque_id_bloque;

    //Constructor vacio
    public AulaEntity() {
    }

    //Constructor lleno
    public AulaEntity(Integer id_aula, String aula_nombre, Integer bloque_id_bloque) {
        this.id_aula = id_aula;
        this.aula_nombre = aula_nombre;
        this.bloque_id_bloque = bloque_id_bloque;
    }

    //getters y setters
    public Integer getId_aula() {
        return id_aula;
    }

    public void setId_aula(Integer id_aula) {
        this.id_aula = id_aula;
    }

    public String getAula_nombre() {
        return aula_nombre;
    }

    public void setAula_nombre(String aula_nombre) {
        this.aula_nombre = aula_nombre;
    }

    public Integer getBloque_id_bloque() {
        return bloque_id_bloque;
    }

    public void setBloque_id_bloque(Integer bloque_id_bloque) {
        this.bloque_id_bloque = bloque_id_bloque;
    }

    
}