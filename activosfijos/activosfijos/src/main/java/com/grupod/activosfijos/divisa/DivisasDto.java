package com.grupod.activosfijos.divisa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.grupod.activosfijos.depreciacion.DepreciacionDto;

public class DivisasDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idDivisa;
    private String nombre;
    private BigDecimal valor;
    private Date fecha;
    private List<DepreciacionDto> depreciaciones;

    public DivisasDto() {
    }

    public DivisasDto(Integer idDivisa, String nombre, BigDecimal valor, Date fecha, List<DepreciacionDto> depreciaciones) {
        this.idDivisa = idDivisa;
        this.nombre = nombre;
        this.valor = valor;
        this.fecha = fecha;
        this.depreciaciones = depreciaciones;
    }

    public Integer getIdDivisa() {
        return idDivisa;
    }

    public void setIdDivisa(Integer idDivisa) {
        this.idDivisa = idDivisa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<DepreciacionDto> getDepreciaciones() {
        return depreciaciones;
    }

    public void setDepreciaciones(List<DepreciacionDto> depreciaciones) {
        this.depreciaciones = depreciaciones;
    }

    @Override
    public String toString() {
        return "DivisasDto{" +
                "idDivisa=" + idDivisa +
                ", nombre='" + nombre + '\'' +
                ", valor=" + valor +
                ", fecha=" + fecha +
                ", depreciaciones=" + depreciaciones +
                '}';
    }
}
