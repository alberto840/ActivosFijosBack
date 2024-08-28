/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.divisa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.grupod.activosfijos.depreciacion.DepreciacionEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "divisas")
public class DivisasEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_divisa")
    private Integer idDivisa;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "divisasId")
    private List<DepreciacionEntity> depreciacionEntityList;

    public DivisasEntity() {
    }

    public DivisasEntity(Integer idDivisa) {
        this.idDivisa = idDivisa;
    }

    public DivisasEntity(Integer idDivisa, String nombre, BigDecimal valor, Date fecha) {
        this.idDivisa = idDivisa;
        this.nombre = nombre;
        this.valor = valor;
        this.fecha = fecha;
    }

    public Integer getIdDivisa() {
        return idDivisa;
    }

    public void setIdDivisa(Integer idDivisa) {
        this.idDivisa = idDivisa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<DepreciacionEntity> getDepreciacionList() {
        return depreciacionEntityList;
    }

    public void setDepreciacionList(List<DepreciacionEntity> depreciacionEntityList) {
        this.depreciacionEntityList = depreciacionEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDivisa != null ? idDivisa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DivisasEntity)) {
            return false;
        }
        DivisasEntity other = (DivisasEntity) object;
        if ((this.idDivisa == null && other.idDivisa != null) || (this.idDivisa != null && !this.idDivisa.equals(other.idDivisa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.moneda.Divisas[ idDivisa=" + idDivisa + " ]";
    }
    
}
