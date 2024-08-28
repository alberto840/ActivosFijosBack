/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.historialActivos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.grupod.activosfijos.activo.ActivoEntity;
import com.grupod.activosfijos.aula.AulaEntity;
import com.grupod.activosfijos.custodio.CustodioEntity;
import com.grupod.activosfijos.proyecto.ProyectoEntity;
import com.grupod.activosfijos.usuario.UsuarioEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "historialactivos")
public class HistorialActivosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historial")
    private Integer idHistorial;
    @Basic(optional = false)
    @Column(name = "accion")
    private String accion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor_actual")
    private BigDecimal valorActual;
    @Basic(optional = false)
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Basic(optional = false)
    @Column(name = "comprobante")
    private String comprobante;
    @Basic(optional = false)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @Basic(optional = false)
    @Column(name = "estado_uso")
    private String estadoUso;
    @JoinColumn(name = "activo_id", referencedColumnName = "id_activo")
    @ManyToOne(optional = false)
    private ActivoEntity activoEntityId;
    @JoinColumn(name = "aula_id", referencedColumnName = "id_aula")
    @ManyToOne(optional = false)
    private AulaEntity aulaEntityId;
    @JoinColumn(name = "custodio_id", referencedColumnName = "id_custodio")
    @ManyToOne(optional = false)
    private CustodioEntity custodioEntityId;
    @JoinColumn(name = "proyecto_id", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private ProyectoEntity proyectoEntityId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private UsuarioEntity usuarioId;

    public HistorialActivosEntity() {
    }

    public HistorialActivosEntity(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public HistorialActivosEntity(Integer idHistorial, String accion, BigDecimal valorActual, Date fechaModificacion, String comprobante, String detalle, boolean estado, String estadoUso) {
        this.idHistorial = idHistorial;
        this.accion = accion;
        this.valorActual = valorActual;
        this.fechaModificacion = fechaModificacion;
        this.comprobante = comprobante;
        this.detalle = detalle;
        this.estado = estado;
        this.estadoUso = estadoUso;
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

    public boolean getEstado() {
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

    public ActivoEntity getActivoId() {
        return activoEntityId;
    }

    public void setActivoId(ActivoEntity activoEntityId) {
        this.activoEntityId = activoEntityId;
    }

    public AulaEntity getAulaId() {
        return aulaEntityId;
    }

    public void setAulaId(AulaEntity aulaEntityId) {
        this.aulaEntityId = aulaEntityId;
    }

    public CustodioEntity getCustodioId() {
        return custodioEntityId;
    }

    public void setCustodioId(CustodioEntity custodioEntityId) {
        this.custodioEntityId = custodioEntityId;
    }

    public ProyectoEntity getProyectoId() {
        return proyectoEntityId;
    }

    public void setProyectoId(ProyectoEntity proyectoEntityId) {
        this.proyectoEntityId = proyectoEntityId;
    }

    public UsuarioEntity getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(UsuarioEntity usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorial != null ? idHistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialActivosEntity)) {
            return false;
        }
        HistorialActivosEntity other = (HistorialActivosEntity) object;
        if ((this.idHistorial == null && other.idHistorial != null) || (this.idHistorial != null && !this.idHistorial.equals(other.idHistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.historialActivos.Historialactivos[ idHistorial=" + idHistorial + " ]";
    }
    
}
