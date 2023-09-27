package com.grupod.activosfijos.actividadesUsers;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table
public class ActividadesUsersEntity {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_actividadesUsers;
    private String usuario_nombre;
    private Integer activo_id_activo;
    private String accion;
    private Date accion_fecha;

    //Constructor lleno
    public ActividadesUsersEntity(Integer id_actividadesUsers, String usuario_nombre, Integer activo_id_activo,
            String accion, Date accion_fecha) {
        this.id_actividadesUsers = id_actividadesUsers;
        this.usuario_nombre = usuario_nombre;
        this.activo_id_activo = activo_id_activo;
        this.accion = accion;
        this.accion_fecha = accion_fecha;
    }

    //Constructor vacio
    public ActividadesUsersEntity() {
    }

    //Getters y setters
    public Integer getId_actividadesUsers() {
        return id_actividadesUsers;
    }

    public void setId_actividadesUsers(Integer id_actividadesUsers) {
        this.id_actividadesUsers = id_actividadesUsers;
    }

    public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public Integer getActivo_id_activo() {
        return activo_id_activo;
    }

    public void setActivo_id_activo(Integer activo_id_activo) {
        this.activo_id_activo = activo_id_activo;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getAccion_fecha() {
        return accion_fecha;
    }

    public void setAccion_fecha(Date accion_fecha) {
        this.accion_fecha = accion_fecha;
    }

    
    
    
}
