package com.grupod.activosfijos.usuario;

import java.io.Serializable;

public class UsuarioDto implements Serializable {
    private Integer idUsuario;
    private String nombre;
    private String correo;
    private boolean estado;
    private String telefono;
    private Integer rolId;

    public UsuarioDto() {
    }

    public UsuarioDto(Integer idUsuario, String nombre, String correo, boolean estado, String telefono, Integer rolId) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.estado = estado;
        this.telefono = telefono;
        this.rolId = rolId;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }
}
