/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.departamento;

import java.io.Serializable;
import java.util.List;


import com.grupod.activosfijos.pais.PaisEntity;

import com.grupod.activosfijos.provincia.ProvinciaEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "departamento")
public class DepartamentoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_departamento")
    private Integer idDepartamento;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departamentoId")
    private List<ProvinciaEntity> provinciaList;
    @JoinColumn(name = "pais_id_pais", referencedColumnName = "id_pais")
    @ManyToOne(optional = false)
    private PaisEntity paisIdPaisEntity;

    public DepartamentoEntity() {
    }

    public DepartamentoEntity(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public DepartamentoEntity(Integer idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ProvinciaEntity> getProvinciaList() {
        return provinciaList;
    }

    public void setProvinciaList(List<ProvinciaEntity> provinciaList) {
        this.provinciaList = provinciaList;
    }

    public PaisEntity getPaisIdPais() {
        return paisIdPaisEntity;
    }

    public void setPaisIdPais(PaisEntity paisIdPaisEntity) {
        this.paisIdPaisEntity = paisIdPaisEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartamento != null ? idDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartamentoEntity)) {
            return false;
        }
        DepartamentoEntity other = (DepartamentoEntity) object;
        if ((this.idDepartamento == null && other.idDepartamento != null) || (this.idDepartamento != null && !this.idDepartamento.equals(other.idDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.departamento.Departamento[ idDepartamento=" + idDepartamento + " ]";
    }
    
}
