package com.grupod.activosfijos.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.grupod.activosfijos.activo.ActivoDto;
import com.grupod.activosfijos.area.AreaDto;
import com.grupod.activosfijos.historialActivos.HistorialActivosDto;

public class ProyectoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idProyecto;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private AreaDto area;
    private List<HistorialActivosDto> historialActivos;
    private List<ActivoDto> activos;

    public ProyectoDto() {
    }

    public ProyectoDto(Integer idProyecto, String nombre, Date fechaInicio, Date fechaFin, AreaDto area, List<HistorialActivosDto> historialActivos, List<ActivoDto> activos) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.area = area;
        this.historialActivos = historialActivos;
        this.activos = activos;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public AreaDto getArea() {
        return area;
    }

    public void setArea(AreaDto area) {
        this.area = area;
    }

    public List<HistorialActivosDto> getHistorialActivos() {
        return historialActivos;
    }

    public void setHistorialActivos(List<HistorialActivosDto> historialActivos) {
        this.historialActivos = historialActivos;
    }

    public List<ActivoDto> getActivos() {
        return activos;
    }

    public void setActivos(List<ActivoDto> activos) {
        this.activos = activos;
    }

    @Override
    public String toString() {
        return "ProyectoDto{" +
                "idProyecto=" + idProyecto +
                ", nombre='" + nombre + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", area=" + area +
                ", historialActivos=" + historialActivos +
                ", activos=" + activos +
                '}';
    }
}
