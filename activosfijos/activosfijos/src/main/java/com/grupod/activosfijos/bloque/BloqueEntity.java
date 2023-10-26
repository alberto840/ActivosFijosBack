package com.grupod.activosfijos.bloque;

import jakarta.persistence.*;

@Entity
@Table
public class BloqueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_bloque;
    private String bloque_nombre;
    private Integer direccion_id_direccion;;

    //Constructor vacio
    public BloqueEntity() {
    }

    //Constructor lleno
    public BloqueEntity(Integer id_bloque, String bloque_nombre, Integer direccion_id_direccion) {
        this.id_bloque = id_bloque;
        this.bloque_nombre = bloque_nombre;
        this.direccion_id_direccion = direccion_id_direccion;;
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

    public Integer getDireccion_id_direccion() {
        return direccion_id_direccion;
    }

    public void setDireccion_id_direccion(Integer direccion_id_direccion) {
        this.direccion_id_direccion = direccion_id_direccion;;
    }

    
}
