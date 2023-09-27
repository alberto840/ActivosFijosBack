package com.grupod.activosfijos.actividadesUsers;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadesUsersRepository extends JpaRepository<ActividadesUsersEntity, Integer>  {
    
}
