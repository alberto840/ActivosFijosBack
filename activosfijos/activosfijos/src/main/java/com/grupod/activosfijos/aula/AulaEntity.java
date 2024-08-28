/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.aula;

import com.grupod.activosfijos.activo.ActivoEntity;
import com.grupod.activosfijos.bloque.BloqueEntity;
import com.grupod.activosfijos.historialActivos.HistorialActivosEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "aula")
public class AulaEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_aula")
    private Integer idAula;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "bloque_id", referencedColumnName = "id_bloque")
    @ManyToOne(optional = false)
    private BloqueEntity bloqueEntityId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aulaId")
    private List<HistorialActivosEntity> historialActivosEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aulaId")
    private List<ActivoEntity> activoEntityList;

    public AulaEntity() {
    }

    public AulaEntity(Integer idAula) {
        this.idAula = idAula;
    }

    public AulaEntity(Integer idAula, String nombre) {
        this.idAula = idAula;
        this.nombre = nombre;
    }

    public Integer getIdAula() {
        return idAula;
    }

    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BloqueEntity getBloqueId() {
        return bloqueEntityId;
    }

    public void setBloqueId(BloqueEntity bloqueEntityId) {
        this.bloqueEntityId = bloqueEntityId;
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
        hash += (idAula != null ? idAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AulaEntity)) {
            return false;
        }
        AulaEntity other = (AulaEntity) object;
        if ((this.idAula == null && other.idAula != null) || (this.idAula != null && !this.idAula.equals(other.idAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.aula.Aula[ idAula=" + idAula + " ]";
    }
    
}
