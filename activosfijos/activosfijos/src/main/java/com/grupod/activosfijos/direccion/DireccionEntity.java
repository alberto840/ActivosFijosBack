package com.grupod.activosfijos.direccion;
import jakarta.persistence.*;

@Entity
@Table
public class DireccionEntity {
     //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_direccion;
    private String direccion_zona;
    private String direccion_calle;
    private String direccion_detalle;
    private Integer provincia_id_provincia;

    //Constructor vacio
    public DireccionEntity() {
    }

    //Constructor lleno
    public DireccionEntity(Integer id_direccion, String direccion_zona, String direccion_calle,
            String direccion_detalle, Integer provincia_id_provincia) {
        this.id_direccion = id_direccion;
        this.direccion_zona = direccion_zona;
        this.direccion_calle = direccion_calle;
        this.direccion_detalle = direccion_detalle;
        this.provincia_id_provincia = provincia_id_provincia;
    }

    //Getters y setters

    public Integer getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(Integer id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getDireccion_zona() {
        return direccion_zona;
    }

    public void setDireccion_zona(String direccion_zona) {
        this.direccion_zona = direccion_zona;
    }

    public String getDireccion_calle() {
        return direccion_calle;
    }

    public void setDireccion_calle(String direccion_calle) {
        this.direccion_calle = direccion_calle;
    }

    public String getDireccion_detalle() {
        return direccion_detalle;
    }

    public void setDireccion_detalle(String direccion_detalle) {
        this.direccion_detalle = direccion_detalle;
    }

    public Integer getProvincia_id_provincia() {
        return provincia_id_provincia;
    }

    public void setProvincia_id_provincia(Integer provincia_id_provincia) {
        this.provincia_id_provincia = provincia_id_provincia;
    }

    

}
