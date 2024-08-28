/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.provincia;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.departamento.DepartamentoEntity;
import com.grupod.activosfijos.municipio.MunicipioEntity;
import jakarta.persistence.*;



@Entity
@Table(name = "provincia")
public class ProvinciaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_provincia")
    private Integer idProvincia;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provinciaId")
    private List<MunicipioEntity> municipioEntityList;
    @JoinColumn(name = "departamento_id", referencedColumnName = "id_departamento")
    @ManyToOne(optional = false)
    private DepartamentoEntity departamentoEntityId;

    public ProvinciaEntity() {
    }

    public ProvinciaEntity(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public ProvinciaEntity(Integer idProvincia, String nombre) {
        this.idProvincia = idProvincia;
        this.nombre = nombre;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<MunicipioEntity> getMunicipioList() {
        return municipioEntityList;
    }

    public void setMunicipioList(List<MunicipioEntity> municipioEntityList) {
        this.municipioEntityList = municipioEntityList;
    }

    public DepartamentoEntity getDepartamentoId() {
        return departamentoEntityId;
    }

    public void setDepartamentoId(DepartamentoEntity departamentoEntityId) {
        this.departamentoEntityId = departamentoEntityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProvincia != null ? idProvincia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProvinciaEntity)) {
            return false;
        }
        ProvinciaEntity other = (ProvinciaEntity) object;
        if ((this.idProvincia == null && other.idProvincia != null) || (this.idProvincia != null && !this.idProvincia.equals(other.idProvincia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.provincia.Provincia[ idProvincia=" + idProvincia + " ]";
    }
    
}
