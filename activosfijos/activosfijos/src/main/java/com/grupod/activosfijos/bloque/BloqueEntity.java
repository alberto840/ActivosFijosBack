/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.bloque;

import com.grupod.activosfijos.activo.ActivoEntity;
import com.grupod.activosfijos.aula.AulaEntity;
import com.grupod.activosfijos.direccion.DireccionEntity;
import com.grupod.activosfijos.sucursal.SucursalEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "bloque")
public class BloqueEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bloque")
    private Integer idBloque;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloqueId")
    private List<AulaEntity> aulaEntityList;
    @JoinColumn(name = "direccion_id", referencedColumnName = "id_direccion")
    @ManyToOne(optional = false)
    private DireccionEntity direccionEntityId;
    @JoinColumn(name = "sucursales_id", referencedColumnName = "id_sucursal")
    @ManyToOne(optional = false)
    private SucursalEntity sucursalEntityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloqueId")
    private List<ActivoEntity> activoEntityList;

    public BloqueEntity() {
    }

    public BloqueEntity(Integer idBloque) {
        this.idBloque = idBloque;
    }

    public BloqueEntity(Integer idBloque, String nombre) {
        this.idBloque = idBloque;
        this.nombre = nombre;
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

    public List<AulaEntity> getAulaList() {
        return aulaEntityList;
    }

    public void setAulaList(List<AulaEntity> aulaEntityList) {
        this.aulaEntityList = aulaEntityList;
    }

    public DireccionEntity getDireccionId() {
        return direccionEntityId;
    }

    public void setDireccionId(DireccionEntity direccionEntityId) {
        this.direccionEntityId = direccionEntityId;
    }

    public SucursalEntity getSucursalesId() {
        return sucursalEntityId;
    }

    public void setSucursalesId(SucursalEntity sucursalEntityId) {
        this.sucursalEntityId = sucursalEntityId;
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
        hash += (idBloque != null ? idBloque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BloqueEntity)) {
            return false;
        }
        BloqueEntity other = (BloqueEntity) object;
        if ((this.idBloque == null && other.idBloque != null) || (this.idBloque != null && !this.idBloque.equals(other.idBloque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.bloque.Bloque[ idBloque=" + idBloque + " ]";
    }
    
}
