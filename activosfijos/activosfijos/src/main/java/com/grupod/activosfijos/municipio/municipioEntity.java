package com.grupod.activosfijos.municipio;

import jakarta.persistence.*;

@Entity
@Table
public class municipioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_municipio;
    private String municipio_nombre;
    private Integer provincia_id_provincia;

    public municipioEntity() {
    }

    public municipioEntity(Integer id_municipio, String municipio_nombre, Integer provincia_id_provincia) {
        this.id_municipio = id_municipio;
        this.municipio_nombre = municipio_nombre;
        this.provincia_id_provincia = provincia_id_provincia;
    }

    public Integer getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(Integer id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getMunicipio_nombre() {
        return municipio_nombre;
    }

    public void setMunicipio_nombre(String municipio_nombre) {
        this.municipio_nombre = municipio_nombre;
    }

    public Integer getProvincia_id_provincia() {
        return provincia_id_provincia;
    }

    public void setProvincia_id_provincia(Integer provincia_id_provincia) {
        this.provincia_id_provincia = provincia_id_provincia;
    }

    @Override
    public String toString() {
        return "municipioEntity{" +
                "id_municipio=" + getId_municipio() +
                ", municipio_nombre='" + getMunicipio_nombre() + '\'' +
                ", provincia_id_provincia=" + getProvincia_id_provincia() +
                '}';
    }
}
