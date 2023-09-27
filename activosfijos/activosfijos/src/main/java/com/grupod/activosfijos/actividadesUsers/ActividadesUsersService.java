package com.grupod.activosfijos.actividadesUsers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ActividadesUsersService {
    private final ActividadesUsersRepository activityRepository;

    @Autowired
    public ActividadesUsersService(ActividadesUsersRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<ActividadesUsersEntity>getActividad(){
        return this.activityRepository.findAll();
    }
    
    public ResponseEntity<Object> addNewRegistroActividades(ActividadesUsersEntity registro) {  
        HashMap<String, Object> datos = new HashMap<>();

        activityRepository.save(registro);
        datos.put("datos", registro);
        datos.put("message", "Se creo el registro de actividades correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    } 
}
