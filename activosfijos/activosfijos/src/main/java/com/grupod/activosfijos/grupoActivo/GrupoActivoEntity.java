package com.grupod.activosfijos.grupoActivo;
import jakarta.persistence.*;

@Entity
@Table
public class GrupoActivoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_grupo;
    private String grupo_nombre;
    public GrupoActivoEntity() {
    }
    public GrupoActivoEntity(Integer id_grupo, String grupo_nombre) {
        this.id_grupo = id_grupo;
        this.grupo_nombre = grupo_nombre;
    }
    public Integer getId_grupo() {
        return id_grupo;
    }
    public void setId_grupo(Integer id_grupo) {
        this.id_grupo = id_grupo;
    }
    public String getGrupo_nombre() {
        return grupo_nombre;
    }
    public void setGrupo_nombre(String grupo_nombre) {
        this.grupo_nombre = grupo_nombre;
    }

    
}
