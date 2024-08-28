package com.grupod.activosfijos.bloque;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.activo.ActivoDto;
import com.grupod.activosfijos.aula.AulaDto;
import com.grupod.activosfijos.direccion.DireccionDto;
import com.grupod.activosfijos.sucursal.SucursalDto;

public class BloqueDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idBloque;
    private String nombre;
    private List<AulaDto> aulas;
    private DireccionDto direccion;
    private SucursalDto sucursal;
    private List<ActivoDto> activos;

    public BloqueDto() {
    }

    public BloqueDto(Integer idBloque, String nombre, List<AulaDto> aulas, DireccionDto direccion, SucursalDto sucursal, List<ActivoDto> activos) {
        this.idBloque = idBloque;
        this.nombre = nombre;
        this.aulas = aulas;
        this.direccion = direccion;
        this.sucursal = sucursal;
        this.activos = activos;
    }

    public Integer getIdBloque() {
        return idBloque;
    }

    public void setIdBloque(Integer idBloque) {
        this.idBloque = idBloque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<AulaDto> getAulas() {
        return aulas;
    }

    public void setAulas(List<AulaDto> aulas) {
        this.aulas = aulas;
    }

    public DireccionDto getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionDto direccion) {
        this.direccion = direccion;
    }

    public SucursalDto getSucursal() {
        return sucursal;
    }

    public void setSucursal(SucursalDto sucursal) {
        this.sucursal = sucursal;
    }

    public List<ActivoDto> getActivos() {
        return activos;
    }

    public void setActivos(List<ActivoDto> activos) {
        this.activos = activos;
    }

    @Override
    public String toString() {
        return "BloqueDto{" +
                "idBloque=" + idBloque +
                ", nombre='" + nombre + '\'' +
                ", aulas=" + aulas +
                ", direccion=" + direccion +
                ", sucursal=" + sucursal +
                ", activos=" + activos +
                '}';
    }
}
