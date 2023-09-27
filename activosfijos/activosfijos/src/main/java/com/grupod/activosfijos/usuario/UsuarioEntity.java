package com.grupod.activosfijos.usuario;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

@Entity
@Table
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;
    private String usuario_nombre;
    private String usuario_pass;
    private String usuario_estado;
    private String usuario_correo;
    private String usuario_telefono;
    private String usuario_rol;

    //Constructor vacio
    public UsuarioEntity() {
    }
    //Constructor lleno
    public UsuarioEntity(Integer id_usuario, String usuario_nombre, String usuario_pass, String usuario_estado,
            String usuario_correo, String usuario_telefono, String usuario_rol) {
        this.id_usuario = id_usuario;
        this.usuario_nombre = usuario_nombre;
        this.usuario_pass = usuario_pass;
        this.usuario_estado = usuario_estado;
        this.usuario_correo = usuario_correo;
        this.usuario_telefono = usuario_telefono;
        this.usuario_rol = usuario_rol;
    }

    //Getters y setters
    public Integer getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getUsuario_nombre() {
        return usuario_nombre;
    }
    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }
    public String getUsuario_pass() {
        return usuario_pass;
    }
    public void setUsuario_pass(String usuario_pass) {
        this.usuario_pass = usuario_pass;
    }
    public String getUsuario_estado() {
        return usuario_estado;
    }
    public void setUsuario_estado(String usuario_estado) {
        this.usuario_estado = usuario_estado;
    }
    public String getUsuario_correo() {
        return usuario_correo;
    }
    public void setUsuario_correo(String usuario_correo) {
        this.usuario_correo = usuario_correo;
    }
    public String getUsuario_telefono() {
        return usuario_telefono;
    }
    public void setUsuario_telefono(String usuario_telefono) {
        this.usuario_telefono = usuario_telefono;
    }
    public String getUsuario_rol() {
        return usuario_rol;
    }
    public void setUsuario_rol(String usuario_rol) {
        this.usuario_rol = usuario_rol;
    }

    
}
