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
    private Integer municipio_id_municipio;

    //Constructor vacio
    public DireccionEntity() {
    }

    //Constructor lleno
    public DireccionEntity(Integer id_direccion, String direccion_zona, String direccion_calle,
            String direccion_detalle, Integer municipio_id_municipio) {
        this.id_direccion = id_direccion;
        this.direccion_zona = direccion_zona;
        this.direccion_calle = direccion_calle;
        this.direccion_detalle = direccion_detalle;
        this.municipio_id_municipio = municipio_id_municipio;
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

    public Integer getMunicipio_id_municipio() {
        return municipio_id_municipio;
    }

    public void setMunicipio_id_municipio(Integer municipio_id_municipio) {
        this.municipio_id_municipio = municipio_id_municipio;
    }

    

}
