package com.grupod.activosfijos.departamento;

import jakarta.persistence.*;

@Entity
@Table
public class departamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_departamento;
    private String departamento_nombre;
    private String pais_id_pais;

    public departamentoEntity() {
    }

    public departamentoEntity(Integer id_departamento, String departamento_nombre, String pais_id_pais) {
        this.id_departamento = id_departamento;
        this.departamento_nombre = departamento_nombre;
        this.pais_id_pais = pais_id_pais;
    }

    public Integer getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(Integer id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getDepartamento_nombre() {
        return departamento_nombre;
    }

    public void setDepartamento_nombre(String departamento_nombre) {
        this.departamento_nombre = departamento_nombre;
    }

    public String getPais_id_pais() {
        return pais_id_pais;
    }

    public void setPais_id_pais(String pais_id_pais) {
        this.pais_id_pais = pais_id_pais;
    }

    @Override
    public String toString() {
        return "departamentoEntity{" +
                "id_departamento=" + getId_departamento() +
                ", departamento_nombre='" + getDepartamento_nombre() + '\'' +
                ", pais_id_pais='" + getPais_id_pais() + '\'' +
                '}';
    }
}
