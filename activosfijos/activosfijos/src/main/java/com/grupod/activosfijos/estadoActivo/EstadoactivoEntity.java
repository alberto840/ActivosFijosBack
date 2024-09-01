/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.estadoActivo;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.activo.ActivoEntity;
import com.grupod.activosfijos.historialActivos.HistorialActivosEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "estadoactivo")
public class EstadoactivoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Integer idEstado;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoactivoEntity")  // Cambia 'estadoactivoEntityId' a 'estadoactivoEntity'
    private List<ActivoEntity> activoEntityList;

    public EstadoactivoEntity() {
    }

    public EstadoactivoEntity(Integer idEstado, String nombre, String descripcion, List<ActivoEntity> activoEntityList) {
        this.idEstado = idEstado;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activoEntityList = activoEntityList;
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

    public List<ActivoEntity> getActivoEntityList() {
        return activoEntityList;
    }

    public void setActivoEntityList(List<ActivoEntity> activoEntityList) {
        this.activoEntityList = activoEntityList;
    }
}
