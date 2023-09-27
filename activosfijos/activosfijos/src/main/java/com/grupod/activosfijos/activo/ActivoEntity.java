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
    private BigDecimal activo_valorCompra;
    private String activo_estadoUsoCompra;
    private Integer activo_cantidad;
    private Boolean activo_estado;
    private Integer categoria_id_activo;
    private Integer imagen_id_imagen;
    private Integer marca_id_marca;
    private String activo_comprobante;
    private Integer imagen_comprobante;

    //Constructor vacio
    public ActivoEntity() {
    }
    //Constructor lleno
    public ActivoEntity(Integer id_activo, String activo_nombre, BigDecimal activo_valorCompra,
            String activo_estadoUsoCompra, Integer activo_cantidad, Boolean activo_estado, Integer categoria_id_activo,
            Integer imagen_id_imagen, Integer marca_id_marca, String activo_comprobante, Integer imagen_comprobante) {
        this.id_activo = id_activo;
        this.activo_nombre = activo_nombre;
        this.activo_valorCompra = activo_valorCompra;
        this.activo_estadoUsoCompra = activo_estadoUsoCompra;
        this.activo_cantidad = activo_cantidad;
        this.activo_estado = activo_estado;
        this.categoria_id_activo = categoria_id_activo;
        this.imagen_id_imagen = imagen_id_imagen;
        this.marca_id_marca = marca_id_marca;
        this.activo_comprobante = activo_comprobante;
        this.imagen_comprobante = imagen_comprobante;
    }
    //Getters setters
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
    public BigDecimal getActivo_valorCompra() {
        return activo_valorCompra;
    }
    public void setActivo_valorCompra(BigDecimal activo_valorCompra) {
        this.activo_valorCompra = activo_valorCompra;
    }
    public String getActivo_estadoUsoCompra() {
        return activo_estadoUsoCompra;
    }
    public void setActivo_estadoUsoCompra(String activo_estadoUsoCompra) {
        this.activo_estadoUsoCompra = activo_estadoUsoCompra;
    }
    public Integer getActivo_cantidad() {
        return activo_cantidad;
    }
    public void setActivo_cantidad(Integer activo_cantidad) {
        this.activo_cantidad = activo_cantidad;
    }
    public Boolean getActivo_estado() {
        return activo_estado;
    }
    public void setActivo_estado(Boolean activo_estado) {
        this.activo_estado = activo_estado;
    }
    public Integer getCategoria_id_activo() {
        return categoria_id_activo;
    }
    public void setCategoria_id_activo(Integer categoria_id_activo) {
        this.categoria_id_activo = categoria_id_activo;
    }
    public Integer getImagen_id_imagen() {
        return imagen_id_imagen;
    }
    public void setImagen_id_imagen(Integer imagen_id_imagen) {
        this.imagen_id_imagen = imagen_id_imagen;
    }
    public Integer getMarca_id_marca() {
        return marca_id_marca;
    }
    public void setMarca_id_marca(Integer marca_id_marca) {
        this.marca_id_marca = marca_id_marca;
    }
    public String getActivo_comprobante() {
        return activo_comprobante;
    }
    public void setActivo_comprobante(String activo_comprobante) {
        this.activo_comprobante = activo_comprobante;
    }
    public Integer getImagen_comprobante() {
        return imagen_comprobante;
    }
    public void setImagen_comprobante(Integer imagen_comprobante) {
        this.imagen_comprobante = imagen_comprobante;
    }

    
}
