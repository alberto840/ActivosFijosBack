package com.grupod.activosfijos.provincia;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.departamento.DepartamentoDto;
import com.grupod.activosfijos.municipio.MunicipioDto;

public class ProvinciaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idProvincia;
    private String nombre;
    private List<MunicipioDto> municipios;
    private DepartamentoDto departamento;

    public ProvinciaDto() {
    }

    public ProvinciaDto(Integer idProvincia, String nombre, List<MunicipioDto> municipios, DepartamentoDto departamento) {
        this.idProvincia = idProvincia;
        this.nombre = nombre;
        this.municipios = municipios;
        this.departamento = departamento;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<MunicipioDto> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<MunicipioDto> municipios) {
        this.municipios = municipios;
    }

    public DepartamentoDto getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDto departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "ProvinciaDto{" +
                "idProvincia=" + idProvincia +
                ", nombre='" + nombre + '\'' +
                ", municipios=" + municipios +
                ", departamento=" + departamento +
                '}';
    }
}
