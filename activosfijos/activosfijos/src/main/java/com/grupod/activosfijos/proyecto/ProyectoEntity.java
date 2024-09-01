/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.proyecto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.grupod.activosfijos.activo.ActivoEntity;
import com.grupod.activosfijos.area.AreaEntity;
import com.grupod.activosfijos.historialActivos.HistorialActivosEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "proyecto")
public class ProyectoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyecto")
    private Integer idProyecto;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    @JoinColumn(name = "area_id", referencedColumnName = "id_area")
    @ManyToOne(optional = false)
    private AreaEntity areaEntityId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectoEntity")
    private List<HistorialActivosEntity> historialActivosEntityList;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyectoEntity")
    private List<ActivoEntity> activoEntityList;

    public ProyectoEntity() {
    }

    public ProyectoEntity(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public ProyectoEntity(Integer idProyecto, String nombre, Date fechaInicio, Date fechaFin) {
        this.idProyecto = idProyecto;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public AreaEntity getAreaId() {
        return areaEntityId;
    }

    public void setAreaId(AreaEntity areaEntityId) {
        this.areaEntityId = areaEntityId;
    }

    public List<HistorialActivosEntity> getHistorialactivosList() {
        return historialActivosEntityList;
    }

    public void setHistorialactivosList(List<HistorialActivosEntity> historialActivosEntityList) {
        this.historialActivosEntityList = historialActivosEntityList;
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
        hash += (idProyecto != null ? idProyecto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProyectoEntity)) {
            return false;
        }
        ProyectoEntity other = (ProyectoEntity) object;
        if ((this.idProyecto == null && other.idProyecto != null) || (this.idProyecto != null && !this.idProyecto.equals(other.idProyecto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.proyecto.Proyecto[ idProyecto=" + idProyecto + " ]";
    }
    
}
