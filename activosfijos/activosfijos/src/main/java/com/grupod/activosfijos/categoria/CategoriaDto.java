package com.grupod.activosfijos.categoria;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.activo.ActivoDto;

public class CategoriaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCategoria;
    private String nombre;
    private List<ActivoDto> activos;

    public CategoriaDto() {
    }

    public CategoriaDto(Integer idCategoria, String nombre, List<ActivoDto> activos) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.activos = activos;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ActivoDto> getActivos() {
        return activos;
    }

    public void setActivos(List<ActivoDto> activos) {
        this.activos = activos;
    }

    @Override
    public String toString() {
        return "CategoriaDto{" +
                "idCategoria=" + idCategoria +
                ", nombre='" + nombre + '\'' +
                ", activos=" + activos +
                '}';
    }
}
