package com.grupod.activosfijos.direccion;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DireccionService {
    private final DireccionRepository direccionRepository;

    @Autowired
    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    public List<DireccionEntity>getDireccion(){
        return this.direccionRepository.findAll();
    }
    public ResponseEntity<Object> addNewDireccion(DireccionEntity direccion) {  
        HashMap<String, Object> datos = new HashMap<>();

        direccionRepository.save(direccion);
        datos.put("datos", direccion);
        datos.put("message", "Se creo la marca correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }
}
