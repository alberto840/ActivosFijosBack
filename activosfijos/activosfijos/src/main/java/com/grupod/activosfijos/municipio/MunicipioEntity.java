/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.municipio;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.provincia.ProvinciaEntity;
import com.grupod.activosfijos.sucursal.SucursalEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "municipio")
public class MunicipioEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_municipio")
    private Integer idMunicipio;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "provincia_id", referencedColumnName = "id_provincia")
    private ProvinciaEntity provinciaId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipioEntity")  // Cambia 'municipioId' a 'municipioEntity'
    private List<SucursalEntity> sucursalEntityList;

    public MunicipioEntity() {
    }

    public MunicipioEntity(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public MunicipioEntity(Integer idMunicipio, String nombre) {
        this.idMunicipio = idMunicipio;
        this.nombre = nombre;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProvinciaEntity getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(ProvinciaEntity provinciaId) {
        this.provinciaId = provinciaId;
    }

    public List<SucursalEntity> getSucursalesList() {
        return sucursalEntityList;
    }

    public void setSucursalesList(List<SucursalEntity> sucursalEntityList) {
        this.sucursalEntityList = sucursalEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipioEntity)) {
            return false;
        }
        MunicipioEntity other = (MunicipioEntity) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.municipio.Municipio[ idMunicipio=" + idMunicipio + " ]";
    }
    
}
