package com.grupod.activosfijos.unidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadRepository extends JpaRepository<UnidadEntity, Integer> {
    
}
