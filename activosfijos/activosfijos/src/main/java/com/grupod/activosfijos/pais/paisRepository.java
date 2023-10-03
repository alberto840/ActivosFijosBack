package com.grupod.activosfijos.pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface paisRepository extends JpaRepository<paisEntity,Integer> {

}
