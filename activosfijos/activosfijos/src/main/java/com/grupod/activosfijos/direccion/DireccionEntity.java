package com.grupod.activosfijos.direccion;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.bloque.BloqueEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "direccion")
public class DireccionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_direccion")
    private Integer idDireccion;

    @Basic(optional = false)
    @Column(name = "calle")
    private String calle;

    @Basic(optional = false)
    @Column(name = "detalle")
    private String detalle;

    @Basic(optional = false)
    @Column(name = "zona")
    private String zona;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "direccionEntityId")
    private List<BloqueEntity> bloqueEntityList;

    public DireccionEntity() {
    }

    public DireccionEntity(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public DireccionEntity(Integer idDireccion, String calle, String detalle, String zona) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.detalle = detalle;
        this.zona = zona;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public List<BloqueEntity> getBloqueEntityList() {
        return bloqueEntityList;
    }

    public void setBloqueEntityList(List<BloqueEntity> bloqueEntityList) {
        this.bloqueEntityList = bloqueEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DireccionEntity)) {
            return false;
        }
        DireccionEntity other = (DireccionEntity) object;
        return (this.idDireccion != null || other.idDireccion == null) && (this.idDireccion == null || this.idDireccion.equals(other.idDireccion));
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.direccion.DireccionEntity[ idDireccion=" + idDireccion + " ]";
    }
}
