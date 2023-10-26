package com.grupod.activosfijos.grupoActivo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoActivoRepository extends JpaRepository<GrupoActivoEntity, Integer>{
    
}
