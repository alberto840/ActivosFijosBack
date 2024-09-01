/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupod.activosfijos.area;

import com.grupod.activosfijos.empresa.EmpresaEntity;
import com.grupod.activosfijos.proyecto.ProyectoEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "area")
public class AreaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private Integer idArea;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "empresa_id", referencedColumnName = "id_empresa")
    private EmpresaEntity empresa;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaEntityId")
    private List<ProyectoEntity> proyectoEntityList;

    public AreaEntity() {
    }

    public AreaEntity(Integer idArea) {
        this.idArea = idArea;
    }

    public AreaEntity(Integer idArea, String nombre, EmpresaEntity empresa, List<ProyectoEntity> proyectoEntityList) {
        this.idArea = idArea;
        this.nombre = nombre;
        this.empresa = empresa;
        this.proyectoEntityList = proyectoEntityList;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EmpresaEntity getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaEntity empresa) {
        this.empresa = empresa;
    }

    public List<ProyectoEntity> getProyectoEntityList() {
        return proyectoEntityList;
    }

    public void setProyectoEntityList(List<ProyectoEntity> proyectoEntityList) {
        this.proyectoEntityList = proyectoEntityList;
    }
}
