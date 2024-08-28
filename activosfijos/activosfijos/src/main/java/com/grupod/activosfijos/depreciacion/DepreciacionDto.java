package com.grupod.activosfijos.depreciacion;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.grupod.activosfijos.activo.ActivoDto;
import com.grupod.activosfijos.divisa.DivisasDto;

public class DepreciacionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idDepreciacion;
    private Date fecha;
    private String metodo;
    private String detalle;
    private DivisasDto divisas;
    private List<ActivoDto> activos;

    public DepreciacionDto() {
    }

    public DepreciacionDto(Integer idDepreciacion, Date fecha, String metodo, String detalle, DivisasDto divisas, List<ActivoDto> activos) {
        this.idDepreciacion = idDepreciacion;
        this.fecha = fecha;
        this.metodo = metodo;
        this.detalle = detalle;
        this.divisas = divisas;
        this.activos = activos;
    }

    public Integer getIdDepreciacion() {
        return idDepreciacion;
    }

    public void setIdDepreciacion(Integer idDepreciacion) {
        this.idDepreciacion = idDepreciacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public DivisasDto getDivisas() {
        return divisas;
    }

    public void setDivisas(DivisasDto divisas) {
        this.divisas = divisas;
    }

    public List<ActivoDto> getActivos() {
        return activos;
    }

    public void setActivos(List<ActivoDto> activos) {
        this.activos = activos;
    }

    @Override
    public String toString() {
        return "DepreciacionDto{" +
                "idDepreciacion=" + idDepreciacion +
                ", fecha=" + fecha +
                ", metodo='" + metodo + '\'' +
                ", detalle='" + detalle + '\'' +
                ", divisas=" + divisas +
                ", activos=" + activos +
                '}';
    }
}
