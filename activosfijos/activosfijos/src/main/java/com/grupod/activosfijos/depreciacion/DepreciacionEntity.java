/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.depreciacion;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.grupod.activosfijos.activo.ActivoEntity;
import com.grupod.activosfijos.divisa.DivisasEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "depreciacion")
public class DepreciacionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_depreciacion")
    private Integer idDepreciacion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "metodo")
    private String metodo;
    @Basic(optional = false)
    @Column(name = "detalle")
    private String detalle;
    @JoinColumn(name = "divisas_id", referencedColumnName = "id_divisa")
    @ManyToOne(optional = false)
    private DivisasEntity divisasEntityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depreciacionId")
    private List<ActivoEntity> activoEntityList;

    public DepreciacionEntity() {
    }

    public DepreciacionEntity(Integer idDepreciacion) {
        this.idDepreciacion = idDepreciacion;
    }

    public DepreciacionEntity(Integer idDepreciacion, Date fecha, String metodo, String detalle) {
        this.idDepreciacion = idDepreciacion;
        this.fecha = fecha;
        this.metodo = metodo;
        this.detalle = detalle;
    }

    public Integer getIdDepreciacion() {
        return idDepreciacion;
    }

    public void setIdDepreciacion(Integer idDepreciacion) {
        this.idDepreciacion = idDepreciacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public DivisasEntity getDivisasId() {
        return divisasEntityId;
    }

    public void setDivisasId(DivisasEntity divisasEntityId) {
        this.divisasEntityId = divisasEntityId;
    }

    public List<ActivoEntity> getActivoList() {
        return activoEntityList;
    }

    public void setActivoList(List<ActivoEntity> activoEntityList) {
        this.activoEntityList = activoEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepreciacion != null ? idDepreciacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepreciacionEntity)) {
            return false;
        }
        DepreciacionEntity other = (DepreciacionEntity) object;
        if ((this.idDepreciacion == null && other.idDepreciacion != null) || (this.idDepreciacion != null && !this.idDepreciacion.equals(other.idDepreciacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.depreciacion.Depreciacion[ idDepreciacion=" + idDepreciacion + " ]";
    }
    
}
