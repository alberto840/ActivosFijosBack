package com.grupod.activosfijos.activo;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table
public class ActivoEntity {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_activo;
    private String activo_nombre;
    private String activo_marca;
    private Integer activo_id;
    private BigDecimal  activo_valor;
    private String activo_categoria;
    private String activo_custodio;
    private String activo_direccion;
    public ActivoEntity(Integer id_activo, String activo_nombre, String activo_marca, Integer activo_id,
            BigDecimal activo_valor, String activo_categoria, String activo_custodio, String activo_direccion) {
        this.id_activo = id_activo;
        this.activo_nombre = activo_nombre;
        this.activo_marca = activo_marca;
        this.activo_id = activo_id;
        this.activo_valor = activo_valor;
        this.activo_categoria = activo_categoria;
        this.activo_custodio = activo_custodio;
        this.activo_direccion = activo_direccion;
    }
    public ActivoEntity() {
    }
    public Integer getId_activo() {
        return id_activo;
    }
    public void setId_activo(Integer id_activo) {
        this.id_activo = id_activo;
    }
    public String getActivo_nombre() {
        return activo_nombre;
    }
    public void setActivo_nombre(String activo_nombre) {
        this.activo_nombre = activo_nombre;
    }
    public String getActivo_marca() {
        return activo_marca;
    }
    public void setActivo_marca(String activo_marca) {
        this.activo_marca = activo_marca;
    }
    public Integer getActivo_id() {
        return activo_id;
    }
    public void setActivo_id(Integer activo_id) {
        this.activo_id = activo_id;
    }
    public BigDecimal getActivo_valor() {
        return activo_valor;
    }
    public void setActivo_valor(BigDecimal activo_valor) {
        this.activo_valor = activo_valor;
    }
    public String getActivo_categoria() {
        return activo_categoria;
    }
    public void setActivo_categoria(String activo_categoria) {
        this.activo_categoria = activo_categoria;
    }
    public String getActivo_custodio() {
        return activo_custodio;
    }
    public void setActivo_custodio(String activo_custodio) {
        this.activo_custodio = activo_custodio;
    }
    public String getActivo_direccion() {
        return activo_direccion;
    }
    public void setActivo_direccion(String activo_direccion) {
        this.activo_direccion = activo_direccion;
    }
    
    
}
