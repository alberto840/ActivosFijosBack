package com.grupod.activosfijos.moneda;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;

@Enabled
@Table
public class MonedaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_moneda;
    private String moneda_tipo;
    private String moneda_signo;

    public MonedaEntity() {
    }

    public MonedaEntity(Integer id_moneda, String moneda_tipo, String moneda_signo) {
        this.id_moneda = id_moneda;
        this.moneda_tipo = moneda_tipo;
        this.moneda_signo = moneda_signo;
    }

    public Integer getId_moneda() {
        return id_moneda;
    }

    public void setId_moneda(Integer id_moneda) {
        this.id_moneda = id_moneda;
    }

    public String getMoneda_tipo() {
        return moneda_tipo;
    }

    public void setMoneda_tipo(String moneda_tipo) {
        this.moneda_tipo = moneda_tipo;
    }

    public String getMoneda_signo() {
        return moneda_signo;
    }

    public void setMoneda_signo(String moneda_signo) {
        this.moneda_signo = moneda_signo;
    }
}
