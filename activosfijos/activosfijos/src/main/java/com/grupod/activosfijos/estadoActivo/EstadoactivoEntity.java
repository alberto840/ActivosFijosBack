/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.estadoActivo;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.activo.ActivoEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "estadoactivo")
public class EstadoactivoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado")
    private Integer idEstado;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoactivoId")
    private List<ActivoEntity> activoEntityList;

    public EstadoactivoEntity() {
    }

    public EstadoactivoEntity(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public EstadoactivoEntity(Integer idEstado, String nombre, String descripcion) {
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoactivoEntity)) {
            return false;
        }
        EstadoactivoEntity other = (EstadoactivoEntity) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.estadoActivo.Estadoactivo[ idEstado=" + idEstado + " ]";
    }
    
}
