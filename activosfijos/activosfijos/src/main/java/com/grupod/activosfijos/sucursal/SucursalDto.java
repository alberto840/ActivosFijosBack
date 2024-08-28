package com.grupod.activosfijos.sucursal;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.bloque.BloqueDto;
import com.grupod.activosfijos.municipio.MunicipioDto;

public class SucursalDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idSucursal;
    private String nombre;
    private MunicipioDto municipio;
    private List<BloqueDto> bloques;

    public SucursalDto() {
    }

    public SucursalDto(Integer idSucursal, String nombre, MunicipioDto municipio, List<BloqueDto> bloques) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
        this.municipio = municipio;
        this.bloques = bloques;
    }

    public Integer getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MunicipioDto getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioDto municipio) {
        this.municipio = municipio;
    }

    public List<BloqueDto> getBloques() {
        return bloques;
    }

    public void setBloques(List<BloqueDto> bloques) {
        this.bloques = bloques;
    }

    @Override
    public String toString() {
        return "SucursalDto{" +
                "idSucursal=" + idSucursal +
                ", nombre='" + nombre + '\'' +
                ", municipio=" + municipio +
                ", bloques=" + bloques +
                '}';
    }
}
