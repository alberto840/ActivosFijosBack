package com.grupod.activosfijos.pais;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.departamento.DepartamentoDto;

public class PaisDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idPais;
    private String nombre;
    private List<DepartamentoDto> departamentos;

    public PaisDto() {
    }

    public PaisDto(Integer idPais, String nombre, List<DepartamentoDto> departamentos) {
        this.idPais = idPais;
        this.nombre = nombre;
        this.departamentos = departamentos;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<DepartamentoDto> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<DepartamentoDto> departamentos) {
        this.departamentos = departamentos;
    }

    @Override
    public String toString() {
        return "PaisDto{" +
                "idPais=" + idPais +
                ", nombre='" + nombre + '\'' +
                ", departamentos=" + departamentos +
                '}';
    }
}
