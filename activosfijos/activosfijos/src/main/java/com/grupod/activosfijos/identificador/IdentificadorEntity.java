/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.identificador;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.activo.ActivoEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "identificador")
public class IdentificadorEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_identificador")
    private Integer idIdentificador;
    @Basic(optional = false)
    @Column(name = "codigo_qr")
    private String codigoQr;
    @Basic(optional = false)
    @Column(name = "codigo_barra")
    private String codigoBarra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "identificadorEntity")  // Cambia 'identificadorId' a 'identificadorEntity'
    private List<ActivoEntity> activoEntityList;

    public IdentificadorEntity() {
    }

    public IdentificadorEntity(Integer idIdentificador) {
        this.idIdentificador = idIdentificador;
    }

    public IdentificadorEntity(Integer idIdentificador, String codigoQr, String codigoBarra) {
        this.idIdentificador = idIdentificador;
        this.codigoQr = codigoQr;
        this.codigoBarra = codigoBarra;
    }

    public Integer getIdIdentificador() {
        return idIdentificador;
    }

    public void setIdIdentificador(Integer idIdentificador) {
        this.idIdentificador = idIdentificador;
    }

    public String getCodigoQr() {
        return codigoQr;
    }

    public void setCodigoQr(String codigoQr) {
        this.codigoQr = codigoQr;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
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
        hash += (idIdentificador != null ? idIdentificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IdentificadorEntity)) {
            return false;
        }
        IdentificadorEntity other = (IdentificadorEntity) object;
        if ((this.idIdentificador == null && other.idIdentificador != null) || (this.idIdentificador != null && !this.idIdentificador.equals(other.idIdentificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.identificador.Identificador[ idIdentificador=" + idIdentificador + " ]";
    }
    
}
