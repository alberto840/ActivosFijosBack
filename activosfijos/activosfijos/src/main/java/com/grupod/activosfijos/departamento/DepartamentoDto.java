package com.grupod.activosfijos.departamento;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.pais.PaisDto;
import com.grupod.activosfijos.provincia.ProvinciaDto;

public class DepartamentoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idDepartamento;
    private String nombre;
    private List<ProvinciaDto> provincias;
    private PaisDto pais;

    public DepartamentoDto() {
    }

    public DepartamentoDto(Integer idDepartamento, String nombre, List<ProvinciaDto> provincias, PaisDto pais) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.provincias = provincias;
        this.pais = pais;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ProvinciaDto> getProvincias() {
        return provincias;
    }

    public void setProvincias(List<ProvinciaDto> provincias) {
        this.provincias = provincias;
    }

    public PaisDto getPais() {
        return pais;
    }

    public void setPais(PaisDto pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "DepartamentoDto{" +
                "idDepartamento=" + idDepartamento +
                ", nombre='" + nombre + '\'' +
                ", provincias=" + provincias +
                ", pais=" + pais +
                '}';
    }
}
