package com.grupod.activosfijos.municipio;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.provincia.ProvinciaDto;
import com.grupod.activosfijos.sucursal.SucursalDto;

public class MunicipioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idMunicipio;
    private String nombre;
    private ProvinciaDto provincia;
    private List<SucursalDto> sucursales;

    public MunicipioDto() {
    }

    public MunicipioDto(Integer idMunicipio, String nombre, ProvinciaDto provincia, List<SucursalDto> sucursales) {
        this.idMunicipio = idMunicipio;
        this.nombre = nombre;
        this.provincia = provincia;
        this.sucursales = sucursales;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProvinciaDto getProvincia() {
        return provincia;
    }

    public void setProvincia(ProvinciaDto provincia) {
        this.provincia = provincia;
    }

    public List<SucursalDto> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<SucursalDto> sucursales) {
        this.sucursales = sucursales;
    }

    @Override
    public String toString() {
        return "MunicipioDto{" +
                "idMunicipio=" + idMunicipio +
                ", nombre='" + nombre + '\'' +
                ", provincia=" + provincia +
                ", sucursales=" + sucursales +
                '}';
    }
}
