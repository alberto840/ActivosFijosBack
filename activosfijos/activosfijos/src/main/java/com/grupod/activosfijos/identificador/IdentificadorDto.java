package com.grupod.activosfijos.identificador;

import java.io.Serializable;

public class IdentificadorDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idIdentificador;
    private String codigoQr;
    private String codigoBarra;

    public IdentificadorDto() {
    }

    public IdentificadorDto(Integer idIdentificador, String codigoQr, String codigoBarra) {
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

    @Override
    public String toString() {
        return "IdentificadorDto{" +
                "idIdentificador=" + idIdentificador +
                ", codigoQr='" + codigoQr + '\'' +
                ", codigoBarra='" + codigoBarra + '\'' +
                '}';
    }
}
