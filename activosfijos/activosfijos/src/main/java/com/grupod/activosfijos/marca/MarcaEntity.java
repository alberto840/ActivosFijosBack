package com.grupod.activosfijos.marca;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
@Table
public class MarcaEntity {
    
     //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_marca;
    private String marca_nombre;

    //Constructor vacio
    public MarcaEntity() {
    }
    //Constructor lleno
    public MarcaEntity(Integer id_marca, String marca_nombre) {
        this.id_marca = id_marca;
        this.marca_nombre = marca_nombre;
    }
    //Getters y setters
    public Integer getId_marca() {
        return id_marca;
    }
    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }
    public String getMarca_nombre() {
        return marca_nombre;
    }
    public void setMarca_nombre(String marca_nombre) {
        this.marca_nombre = marca_nombre;
    }

    
}
