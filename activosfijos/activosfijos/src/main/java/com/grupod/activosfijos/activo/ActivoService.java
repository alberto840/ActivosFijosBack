package com.grupod.activosfijos.activo;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ActivoService {
    private final ActivoRepository activoRepository;

    @Autowired
    public ActivoService(ActivoRepository activoRepository) {
        this.activoRepository = activoRepository;
    }

    public List<ActivoEntity>getActivo(){
        return this.activoRepository.findAll();
    }
    public ResponseEntity<Object> addNewActivo(ActivoEntity activo) {  
        HashMap<String, Object> datos = new HashMap<>();

        activoRepository.save(activo);
        datos.put("datos", activo);
        datos.put("message", "Se creo el activo correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    } 
}
