package com.grupod.activosfijos.moneda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedaRepository extends JpaRepository<MonedaEntity,Integer> {

}
