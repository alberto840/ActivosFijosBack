package com.grupod.activosfijos.ubicacionActivo;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table
public class ubicacionActivoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_ubicacionActivo;
    private Integer ubicacionActivo_cantidad;
    private String activo_id_activo;
    private Date ubicacionActivo_fecha;
    private Integer aula_id_aula;
    private Integer usuario_id_usuario;

    public ubicacionActivoEntity() {
    }

    public ubicacionActivoEntity(Integer id_ubicacionActivo, Integer ubicacionActivo_cantidad,
                                 String activo_id_activo, Date ubicacionActivo_fecha, Integer aula_id_aula,
                                 Integer usuario_id_usuario) {
        this.id_ubicacionActivo = id_ubicacionActivo;
        this.ubicacionActivo_cantidad = ubicacionActivo_cantidad;
        this.activo_id_activo = activo_id_activo;
        this.ubicacionActivo_fecha = ubicacionActivo_fecha;
        this.aula_id_aula = aula_id_aula;
        this.usuario_id_usuario = usuario_id_usuario;
    }

    public Integer getId_ubicacionActivo() {
        return id_ubicacionActivo;
    }

    public void setId_ubicacionActivo(Integer id_ubicacionActivo) {
        this.id_ubicacionActivo = id_ubicacionActivo;
    }

    public Integer getUbicacionActivo_cantidad() {
        return ubicacionActivo_cantidad;
    }

    public void setUbicacionActivo_cantidad(Integer ubicacionActivo_cantidad) {
        this.ubicacionActivo_cantidad = ubicacionActivo_cantidad;
    }

    public String getActivo_id_activo() {
        return activo_id_activo;
    }

    public void setActivo_id_activo(String activo_id_activo) {
        this.activo_id_activo = activo_id_activo;
    }

    public Date getUbicacionActivo_fecha() {
        return ubicacionActivo_fecha;
    }

    public void setUbicacionActivo_fecha(Date ubicacionActivo_fecha) {
        this.ubicacionActivo_fecha = ubicacionActivo_fecha;
    }

    public Integer getAula_id_aula() {
        return aula_id_aula;
    }

    public void setAula_id_aula(Integer aula_id_aula) {
        this.aula_id_aula = aula_id_aula;
    }

    public Integer getUsuario_id_usuario() {
        return usuario_id_usuario;
    }

    public void setUsuario_id_usuario(Integer usuario_id_usuario) {
        this.usuario_id_usuario = usuario_id_usuario;
    }
}
