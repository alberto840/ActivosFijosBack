package com.grupod.activosfijos.unidad;
import jakarta.persistence.*;

@Entity
@Table
public class UnidadEntity {
     //Atributos
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id_unidad;
     private String unidad_nombre;
     private Integer direccion_id_direccion;
     //constructor vacio
    public UnidadEntity() {
    }
    //constructor lleno
    public UnidadEntity(Integer id_unidad, String unidad_nombre, Integer direccion_id_direccion) {
        this.id_unidad = id_unidad;
        this.unidad_nombre = unidad_nombre;
        this.direccion_id_direccion = direccion_id_direccion;
    }

    //Getters y setters
    public Integer getId_unidad() {
        return id_unidad;
    }
    public void setId_unidad(Integer id_unidad) {
        this.id_unidad = id_unidad;
    }
    public String getUnidad_nombre() {
        return unidad_nombre;
    }
    public void setUnidad_nombre(String unidad_nombre) {
        this.unidad_nombre = unidad_nombre;
    }
    public Integer getDireccion_id_direccion() {
        return direccion_id_direccion;
    }
    public void setDireccion_id_direccion(Integer direccion_id_direccion) {
        this.direccion_id_direccion = direccion_id_direccion;
    }

    

     
}
