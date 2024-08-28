package com.grupod.activosfijos.aula;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.activo.ActivoDto;
import com.grupod.activosfijos.bloque.BloqueDto;
import com.grupod.activosfijos.historialActivos.HistorialActivosDto;

public class AulaDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idAula;
    private String nombre;
    private BloqueDto bloque;
    private List<HistorialActivosDto> historialActivos;
    private List<ActivoDto> activos;

    public AulaDto() {
    }

    public AulaDto(Integer idAula, String nombre, BloqueDto bloque, List<HistorialActivosDto> historialActivos, List<ActivoDto> activos) {
        this.idAula = idAula;
        this.nombre = nombre;
        this.bloque = bloque;
        this.historialActivos = historialActivos;
        this.activos = activos;
    }

    public Integer getIdAula() {
        return idAula;
    }

    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BloqueDto getBloque() {
        return bloque;
    }

    public void setBloque(BloqueDto bloque) {
        this.bloque = bloque;
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
        return "AulaDto{" +
                "idAula=" + idAula +
                ", nombre='" + nombre + '\'' +
                ", bloque=" + bloque +
                ", historialActivos=" + historialActivos +
                ", activos=" + activos +
                '}';
    }
}
