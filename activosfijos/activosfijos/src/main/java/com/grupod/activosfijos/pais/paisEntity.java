package com.grupod.activosfijos.pais;

import jakarta.persistence.*;

@Entity
@Table
public class paisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pais_nombre;

    public paisEntity() {
    }

    public paisEntity(Integer id, String pais_nombre) {
        this.id = id;
        this.pais_nombre = pais_nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPais_nombre() {
        return pais_nombre;
    }

    public void setPais_nombre(String pais_nombre) {
        this.pais_nombre = pais_nombre;
    }

    @Override
    public String toString() {
        return "paisEntity{" +
                "id=" + getId() +
                ", pais_nombre='" + getPais_nombre() + '\'' +
                '}';
    }
}
