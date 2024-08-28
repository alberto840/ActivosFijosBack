/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.area;

import com.grupod.activosfijos.empresa.EmpresaEntity;
import com.grupod.activosfijos.proyecto.ProyectoEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "area")
public class AreaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_area")
    private Integer idArea;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "empresa_id", referencedColumnName = "id_empresa")
    @ManyToOne(optional = false)
    private EmpresaEntity empresaEntityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaId")
    private List<ProyectoEntity> proyectoEntityList;

    public AreaEntity() {
    }

    public AreaEntity(Integer idArea) {
        this.idArea = idArea;
    }

    public AreaEntity(Integer idArea, String nombre) {
        this.idArea = idArea;
        this.nombre = nombre;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EmpresaEntity getEmpresaId() {
        return empresaEntityId;
    }

    public void setEmpresaId(EmpresaEntity empresaEntityId) {
        this.empresaEntityId = empresaEntityId;
    }

    public List<ProyectoEntity> getProyectoList() {
        return proyectoEntityList;
    }

    public void setProyectoList(List<ProyectoEntity> proyectoEntityList) {
        this.proyectoEntityList = proyectoEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArea != null ? idArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaEntity)) {
            return false;
        }
        AreaEntity other = (AreaEntity) object;
        if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.area.Area[ idArea=" + idArea + " ]";
    }
    
}
