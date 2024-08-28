package com.grupod.activosfijos.identificador;

import java.io.Serializable;
import java.util.List;

import com.grupod.activosfijos.activo.ActivoDto;

public class IdentificadorDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idIdentificador;
    private String codigoQr;
    private String codigoBarra;
    private List<ActivoDto> activos;

    public IdentificadorDto() {
    }

    public IdentificadorDto(Integer idIdentificador, String codigoQr, String codigoBarra, List<ActivoDto> activos) {
        this.idIdentificador = idIdentificador;
        this.codigoQr = codigoQr;
        this.codigoBarra = codigoBarra;
        this.activos = activos;
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

    public List<ActivoDto> getActivos() {
        return activos;
    }

    public void setActivos(List<ActivoDto> activos) {
        this.activos = activos;
    }

    @Override
    public String toString() {
        return "IdentificadorDto{" +
                "idIdentificador=" + idIdentificador +
                ", codigoQr='" + codigoQr + '\'' +
                ", codigoBarra='" + codigoBarra + '\'' +
                ", activos=" + activos +
                '}';
    }
}
