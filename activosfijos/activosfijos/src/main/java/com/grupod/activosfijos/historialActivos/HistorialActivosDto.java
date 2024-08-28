package com.grupod.activosfijos.historialActivos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.grupod.activosfijos.activo.ActivoDto;
import com.grupod.activosfijos.aula.AulaDto;
import com.grupod.activosfijos.custodio.CustodioDto;
import com.grupod.activosfijos.proyecto.ProyectoDto;
import com.grupod.activosfijos.usuario.UsuarioDto;

public class HistorialActivosDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idHistorial;
    private String accion;
    private BigDecimal valorActual;
    private Date fechaModificacion;
    private String comprobante;
    private String detalle;
    private boolean estado;
    private String estadoUso;
    private ActivoDto activo;
    private AulaDto aula;
    private CustodioDto custodio;
    private ProyectoDto proyecto;
    private UsuarioDto usuario;

    public HistorialActivosDto() {
    }

    public HistorialActivosDto(Integer idHistorial, String accion, BigDecimal valorActual, Date fechaModificacion, String comprobante, String detalle, boolean estado, String estadoUso, ActivoDto activo, AulaDto aula, CustodioDto custodio, ProyectoDto proyecto, UsuarioDto usuario) {
        this.idHistorial = idHistorial;
        this.accion = accion;
        this.valorActual = valorActual;
        this.fechaModificacion = fechaModificacion;
        this.comprobante = comprobante;
        this.detalle = detalle;
        this.estado = estado;
        this.estadoUso = estadoUso;
        this.activo = activo;
        this.aula = aula;
        this.custodio = custodio;
        this.proyecto = proyecto;
        this.usuario = usuario;
    }

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public BigDecimal getValorActual() {
        return valorActual;
    }

    public void setValorActual(BigDecimal valorActual) {
        this.valorActual = valorActual;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getEstadoUso() {
        return estadoUso;
    }

    public void setEstadoUso(String estadoUso) {
        this.estadoUso = estadoUso;
    }

    public ActivoDto getActivo() {
        return activo;
    }

    public void setActivo(ActivoDto activo) {
        this.activo = activo;
    }

    public AulaDto getAula() {
        return aula;
    }

    public void setAula(AulaDto aula) {
        this.aula = aula;
    }

    public CustodioDto getCustodio() {
        return custodio;
    }

    public void setCustodio(CustodioDto custodio) {
        this.custodio = custodio;
    }

    public ProyectoDto getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoDto proyecto) {
        this.proyecto = proyecto;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "HistorialActivosDto{" +
                "idHistorial=" + idHistorial +
                ", accion='" + accion + '\'' +
                ", valorActual=" + valorActual +
                ", fechaModificacion=" + fechaModificacion +
                ", comprobante='" + comprobante + '\'' +
                ", detalle='" + detalle + '\'' +
                ", estado=" + estado +
                ", estadoUso='" + estadoUso + '\'' +
                ", activo=" + activo +
                ", aula=" + aula +
                ", custodio=" + custodio +
                ", proyecto=" + proyecto +
                ", usuario=" + usuario +
                '}';
    }
}
