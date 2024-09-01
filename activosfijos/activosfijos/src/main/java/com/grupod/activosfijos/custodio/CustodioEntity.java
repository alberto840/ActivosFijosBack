/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.custodio;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.activo.ActivoEntity;
import com.grupod.activosfijos.historialActivos.HistorialActivosEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "custodio")
public class CustodioEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_custodio")
    private Integer idCustodio;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Basic(optional = false)
    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;

    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custodioEntity")  // Cambia 'custodioEntityId' a 'custodioEntity'
    private List<HistorialActivosEntity> historialActivosEntityList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "custodioEntity")  // Cambia 'custodioEntityId' a 'custodioEntity'
    private List<ActivoEntity> activoEntityList;

    public CustodioEntity() {
    }

    public CustodioEntity(Integer idCustodio) {
        this.idCustodio = idCustodio;
    }

    public CustodioEntity(Integer idCustodio, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String telefono) {
        this.idCustodio = idCustodio;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Integer getIdCustodio() {
        return idCustodio;
    }

    public void setIdCustodio(Integer idCustodio) {
        this.idCustodio = idCustodio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        hash += (idCustodio != null ? idCustodio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustodioEntity)) {
            return false;
        }
        CustodioEntity other = (CustodioEntity) object;
        if ((this.idCustodio == null && other.idCustodio != null) || (this.idCustodio != null && !this.idCustodio.equals(other.idCustodio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.custodio.Custodio[ idCustodio=" + idCustodio + " ]";
    }
    
}
