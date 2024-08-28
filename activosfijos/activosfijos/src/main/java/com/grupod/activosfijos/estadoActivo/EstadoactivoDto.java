package com.grupod.activosfijos.estadoActivo;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.activo.ActivoDto;

public class EstadoactivoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idEstado;
    private String nombre;
    private String descripcion;
    private List<ActivoDto> activos;

    public EstadoactivoDto() {
    }

    public EstadoactivoDto(Integer idEstado, String nombre, String descripcion, List<ActivoDto> activos) {
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activos = activos;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<ActivoDto> getActivos() {
        return activos;
    }

    public void setActivos(List<ActivoDto> activos) {
        this.activos = activos;
    }

    @Override
    public String toString() {
        return "EstadoactivoDto{" +
                "idEstado=" + idEstado +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", activos=" + activos +
                '}';
    }
}
