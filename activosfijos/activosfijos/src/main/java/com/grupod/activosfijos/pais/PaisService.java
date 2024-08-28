package com.grupod.activosfijos.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PaisService {
    private final PaisRepository paisRepository;
    @Autowired
    public PaisService(PaisRepository paisRepository){
        this.paisRepository = paisRepository;
    }

    public List<PaisEntity>getPais(){
        return this.paisRepository.findAll();
    }
    public ResponseEntity<Object> addNewPais(PaisEntity pais) {
        HashMap<String, Object> datos = new HashMap<>();

        paisRepository.save(pais);
        datos.put("datos", pais);
        datos.put("message", "Se creo el pais correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    } 
}
