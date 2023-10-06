package com.grupod.activosfijos.unidad;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UnidadService {
private final UnidadRepository unidadRepository;

    @Autowired
    public UnidadService(UnidadRepository unidadRepository) {
        this.unidadRepository = unidadRepository;
    }

    public List<UnidadEntity> getUnidad(){
        return this.unidadRepository.findAll();
    }
    public ResponseEntity<Object> addNewUnidad(UnidadEntity unidad) {  
        HashMap<String, Object> datos = new HashMap<>();

        unidadRepository.save(unidad);
        datos.put("datos", unidad);
        datos.put("message", "Se creo la marca correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }

}
