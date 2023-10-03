package com.grupod.activosfijos.ubicacionActivo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ubicacionActivoRepository extends JpaRepository<ubicacionActivoEntity, Integer> {

}
