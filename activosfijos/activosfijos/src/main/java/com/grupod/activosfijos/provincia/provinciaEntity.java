package com.grupod.activosfijos.provincia;

import jakarta.persistence.*;

@Entity
@Table
public class provinciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_provincia;
    private String provincia_nombre;
    private Integer departamento_id_departamento;

    public provinciaEntity() {
    }

    public provinciaEntity(Integer id_provincia, String provincia_nombre, Integer departamento_id_departamento) {
        this.id_provincia = id_provincia;
        this.provincia_nombre = provincia_nombre;
        this.departamento_id_departamento = departamento_id_departamento;
    }

    public Integer getId_provincia() {
        return id_provincia;
    }

    public void setId_provincia(Integer id_provincia) {
        this.id_provincia = id_provincia;
    }

    public String getProvincia_nombre() {
        return provincia_nombre;
    }

    public void setProvincia_nombre(String provincia_nombre) {
        this.provincia_nombre = provincia_nombre;
    }

    public Integer getDepartamento_id_departamento() {
        return departamento_id_departamento;
    }

    public void setDepartamento_id_departamento(Integer departamento_id_departamento) {
        this.departamento_id_departamento = departamento_id_departamento;
    }

    @Override
    public String toString() {
        return "provinciaEntity{" +
                "id_provincia=" + getId_provincia() +
                ", provincia_nombre='" + getProvincia_nombre() + '\'' +
                ", departamento_id_departamento=" + getDepartamento_id_departamento() +
                '}';
    }
}
