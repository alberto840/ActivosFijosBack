package com.grupod.activosfijos.custodio;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.activo.ActivoDto;
import com.grupod.activosfijos.historialActivos.HistorialActivosDto;

public class CustodioDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idCustodio;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String telefono;
    private List<HistorialActivosDto> historialActivos;
    private List<ActivoDto> activos;

    public CustodioDto() {
    }

    public CustodioDto(Integer idCustodio, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String telefono, List<HistorialActivosDto> historialActivos, List<ActivoDto> activos) {
        this.idCustodio = idCustodio;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.telefono = telefono;
        this.historialActivos = historialActivos;
        this.activos = activos;
    }

    public Integer getIdCustodio() {
        return idCustodio;
    }

    public void setIdCustodio(Integer idCustodio) {
        this.idCustodio = idCustodio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<HistorialActivosDto> getHistorialActivos() {
        return historialActivos;
    }

    public void setHistorialActivos(List<HistorialActivosDto> historialActivos) {
        this.historialActivos = historialActivos;
    }

    public List<ActivoDto> getActivos() {
        return activos;
    }

    public void setActivos(List<ActivoDto> activos) {
        this.activos = activos;
    }

    @Override
    public String toString() {
        return "CustodioDto{" +
                "idCustodio=" + idCustodio +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", historialActivos=" + historialActivos +
                ", activos=" + activos +
                '}';
    }
}
