package com.grupod.activosfijos.identificador;

import jakarta.persistence.*;
import java.io.Serializable;

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

    // Constructor vacío
    public IdentificadorEntity() {}

    // Constructor completo
    public IdentificadorEntity(Integer idIdentificador, String codigoQr, String codigoBarra) {
        this.idIdentificador = idIdentificador;
        this.codigoQr = codigoQr;
        this.codigoBarra = codigoBarra;
    }

    // Getters y Setters
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIdentificador != null ? idIdentificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof IdentificadorEntity)) {
            return false;
        }
        IdentificadorEntity other = (IdentificadorEntity) object;
        return (this.idIdentificador != null || other.idIdentificador == null) && (this.idIdentificador == null || this.idIdentificador.equals(other.idIdentificador));
    }

    @Override
    public String toString() {
        return "IdentificadorEntity[ idIdentificador=" + idIdentificador + " ]";
    }
}
