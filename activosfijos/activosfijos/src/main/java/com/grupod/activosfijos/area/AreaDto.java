package com.grupod.activosfijos.area;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.empresa.EmpresaDto;
import com.grupod.activosfijos.proyecto.ProyectoDto;

public class AreaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idArea;
    private String nombre;
    private EmpresaDto empresa;
    private List<ProyectoDto> proyectos;

    public AreaDto() {
    }

    public AreaDto(Integer idArea, String nombre, EmpresaDto empresa, List<ProyectoDto> proyectos) {
        this.idArea = idArea;
        this.nombre = nombre;
        this.empresa = empresa;
        this.proyectos = proyectos;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EmpresaDto getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDto empresa) {
        this.empresa = empresa;
    }

    public List<ProyectoDto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(List<ProyectoDto> proyectos) {
        this.proyectos = proyectos;
    }

    @Override
    public String toString() {
        return "AreaDto{" +
                "idArea=" + idArea +
                ", nombre='" + nombre + '\'' +
                ", empresa=" + empresa +
                ", proyectos=" + proyectos +
                '}';
    }
}
