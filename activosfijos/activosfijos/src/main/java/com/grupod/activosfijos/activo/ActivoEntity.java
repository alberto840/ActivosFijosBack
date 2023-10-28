package com.grupod.activosfijos.activo;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table
public class ActivoEntity {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_activo;
    private String activo_nombre;
    private Date activo_fecha;
    private Integer activo_categoria;
    private Integer marca_id_marca;
    private String activo_comprobante;
    private Integer pais_id_pais;
    private Integer departamento_id_departamento;
    private Integer provincia_id_provincia;
    private String direccion_id_direccion;
    private Integer bloque_id_bloque;
    private Integer aula_id_aula;
    private BigDecimal activo_valor_inicial;
    private BigDecimal activo_valor_actual;
    private String custodio_id_custodio;
    private String activo_detalle;
    private String activo_estado;
    private Integer grupo_id_grupo;
    
    public ActivoEntity() {
    }


    public ActivoEntity(Integer id_activo, String activo_nombre, Date activo_fecha, Integer activo_categoria,
            Integer marca_id_marca, String activo_comprobante, Integer pais_id_pais,
            Integer departamento_id_departamento, Integer provincia_id_provincia, String direccion_id_direccion,
            Integer bloque_id_bloque, Integer aula_id_aula, BigDecimal activo_valor_inicial,
            BigDecimal activo_valor_actual, String custodio_id_custodio, String activo_detalle, String activo_estado,
            Integer grupo_id_grupo) {
        this.id_activo = id_activo;
        this.activo_nombre = activo_nombre;
        this.activo_fecha = activo_fecha;
        this.activo_categoria = activo_categoria;
        this.marca_id_marca = marca_id_marca;
        this.activo_comprobante = activo_comprobante;
        this.pais_id_pais = pais_id_pais;
        this.departamento_id_departamento = departamento_id_departamento;
        this.provincia_id_provincia = provincia_id_provincia;
        this.direccion_id_direccion = direccion_id_direccion;
        this.bloque_id_bloque = bloque_id_bloque;
        this.aula_id_aula = aula_id_aula;
        this.activo_valor_inicial = activo_valor_inicial;
        this.activo_valor_actual = activo_valor_actual;
        this.custodio_id_custodio = custodio_id_custodio;
        this.activo_detalle = activo_detalle;
        this.activo_estado = activo_estado;
        this.grupo_id_grupo = grupo_id_grupo;
    }


    public Integer getId_activo() {
        return id_activo;
    }

    public String getActivo_estado() {
        return activo_estado;
    }


    public void setActivo_estado(String activo_estado) {
        this.activo_estado = activo_estado;
    }


    public Integer getGrupo_id_grupo() {
        return grupo_id_grupo;
    }


    public void setGrupo_id_grupo(Integer grupo_id_grupo) {
        this.grupo_id_grupo = grupo_id_grupo;
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

    public Date getActivo_fecha() {
        return activo_fecha;
    }

    public void setActivo_fecha(Date activo_fecha) {
        this.activo_fecha = activo_fecha;
    }

    public Integer getActivo_categoria() {
        return activo_categoria;
    }

    public void setActivo_categoria(Integer activo_categoria) {
        this.activo_categoria = activo_categoria;
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

    public Integer getPais_id_pais() {
        return pais_id_pais;
    }

    public void setPais_id_pais(Integer pais_id_pais) {
        this.pais_id_pais = pais_id_pais;
    }

    public Integer getDepartamento_id_departamento() {
        return departamento_id_departamento;
    }

    public void setDepartamento_id_departamento(Integer departamento_id_departamento) {
        this.departamento_id_departamento = departamento_id_departamento;
    }

    public Integer getProvincia_id_provincia() {
        return provincia_id_provincia;
    }

    public void setProvincia_id_provincia(Integer provincia_id_provincia) {
        this.provincia_id_provincia = provincia_id_provincia;
    }

    public String getDireccion_id_direccion() {
        return direccion_id_direccion;
    }

    public void setDireccion_id_direccion(String direccion_id_direccion) {
        this.direccion_id_direccion = direccion_id_direccion;
    }

    public Integer getBloque_id_bloque() {
        return bloque_id_bloque;
    }

    public void setBloque_id_bloque(Integer bloque_id_bloque) {
        this.bloque_id_bloque = bloque_id_bloque;
    }

    public Integer getAula_id_aula() {
        return aula_id_aula;
    }

    public void setAula_id_aula(Integer aula_id_aula) {
        this.aula_id_aula = aula_id_aula;
    }

    public BigDecimal getActivo_valor_inicial() {
        return activo_valor_inicial;
    }

    public void setActivo_valor_inicial(BigDecimal activo_valor_inicial) {
        this.activo_valor_inicial = activo_valor_inicial;
    }

    public BigDecimal getActivo_valor_actual() {
        return activo_valor_actual;
    }

    public void setActivo_valor_actual(BigDecimal activo_valor_actual) {
        this.activo_valor_actual = activo_valor_actual;
    }

    public String getCustodio_id_custodio() {
        return custodio_id_custodio;
    }

    public void setCustodio_id_custodio(String custodio_id_custodio) {
        this.custodio_id_custodio = custodio_id_custodio;
    }

    public String getActivo_detalle() {
        return activo_detalle;
    }

    public void setActivo_detalle(String activo_detalle) {
        this.activo_detalle = activo_detalle;
    }
    
    
}
