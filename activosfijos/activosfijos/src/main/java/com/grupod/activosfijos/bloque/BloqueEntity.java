package com.grupod.activosfijos.bloque;

import com.grupod.activosfijos.activo.ActivoEntity;
import com.grupod.activosfijos.aula.AulaEntity;
import com.grupod.activosfijos.direccion.DireccionEntity;
import com.grupod.activosfijos.sucursal.SucursalEntity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bloque")
public class BloqueEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_bloque")
    private Integer idBloque;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloqueEntity")
    private List<ActivoEntity> activoEntityList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloqueEntity")
    private List<AulaEntity> aulaEntityList;

    @JoinColumn(name = "direccion_id", referencedColumnName = "id_direccion")
    @ManyToOne(optional = false)
    private DireccionEntity direccionEntityId;

    @ManyToOne
    @JoinColumn(name = "sucursal_id", referencedColumnName = "id_sucursal")
    private SucursalEntity sucursalEntity;


    public BloqueEntity() {
    }

    public BloqueEntity(Integer idBloque, String nombre, List<ActivoEntity> activoEntityList, List<AulaEntity> aulaEntityList, DireccionEntity direccionEntityId, SucursalEntity sucursalEntity) {
        this.idBloque = idBloque;
        this.nombre = nombre;
        this.activoEntityList = activoEntityList;
        this.aulaEntityList = aulaEntityList;
        this.direccionEntityId = direccionEntityId;
        this.sucursalEntity = sucursalEntity;
    }

    public Integer getIdBloque() {
        return idBloque;
    }

    public void setIdBloque(Integer idBloque) {
        this.idBloque = idBloque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<ActivoEntity> getActivoEntityList() {
        return activoEntityList;
    }

    public void setActivoEntityList(List<ActivoEntity> activoEntityList) {
        this.activoEntityList = activoEntityList;
    }

    public List<AulaEntity> getAulaEntityList() {
        return aulaEntityList;
    }

    public void setAulaEntityList(List<AulaEntity> aulaEntityList) {
        this.aulaEntityList = aulaEntityList;
    }

    public DireccionEntity getDireccionEntityId() {
        return direccionEntityId;
    }

    public void setDireccionEntityId(DireccionEntity direccionEntityId) {
        this.direccionEntityId = direccionEntityId;
    }

    public SucursalEntity getSucursalEntity() {
        return sucursalEntity;
    }

    public void setSucursalEntity(SucursalEntity sucursalEntity) {
        this.sucursalEntity = sucursalEntity;
    }
}
