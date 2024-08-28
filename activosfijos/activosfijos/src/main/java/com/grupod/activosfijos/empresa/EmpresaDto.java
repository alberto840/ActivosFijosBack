package com.grupod.activosfijos.empresa;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.area.AreaDto;

public class EmpresaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idEmpresa;
    private String nombre;
    private String direccion;
    private String nit;
    private String telefono;
    private List<AreaDto> areas;

    public EmpresaDto() {
    }

    public EmpresaDto(Integer idEmpresa, String nombre, String direccion, String nit, String telefono, List<AreaDto> areas) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        this.telefono = telefono;
        this.areas = areas;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<AreaDto> getAreas() {
        return areas;
    }

    public void setAreas(List<AreaDto> areas) {
        this.areas = areas;
    }

    @Override
    public String toString() {
        return "EmpresaDto{" +
                "idEmpresa=" + idEmpresa +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nit='" + nit + '\'' +
                ", telefono='" + telefono + '\'' +
                ", areas=" + areas +
                '}';
    }
}
