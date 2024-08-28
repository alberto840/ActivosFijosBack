package com.grupod.activosfijos.sucursal;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.bloque.BloqueEntity;
import com.grupod.activosfijos.municipio.MunicipioEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "sucursales")
public class SucursalEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sucursal")
    private Integer idSucursal;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "municipio_id", referencedColumnName = "id_municipio")
    @ManyToOne(optional = false)
    private MunicipioEntity municipioEntityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sucursalesId")
    private List<BloqueEntity> bloqueEntityList;

    public SucursalEntity() {
    }

    public SucursalEntity(Integer idSucursal) {
        this.idSucursal = idSucursal;
    }

    public SucursalEntity(Integer idSucursal, String nombre) {
        this.idSucursal = idSucursal;
        this.nombre = nombre;
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

    public MunicipioEntity getMunicipioId() {
        return municipioEntityId;
    }

    public void setMunicipioId(MunicipioEntity municipioEntityId) {
        this.municipioEntityId = municipioEntityId;
    }

    public List<BloqueEntity> getBloqueList() {
        return bloqueEntityList;
    }

    public void setBloqueList(List<BloqueEntity> bloqueEntityList) {
        this.bloqueEntityList = bloqueEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSucursal != null ? idSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SucursalEntity)) {
            return false;
        }
        SucursalEntity other = (SucursalEntity) object;
        if ((this.idSucursal == null && other.idSucursal != null) || (this.idSucursal != null && !this.idSucursal.equals(other.idSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.sucursal.Sucursales[ idSucursal=" + idSucursal + " ]";
    }
    
}
