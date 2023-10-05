package com.grupod.activosfijos.aula;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AulaService {
    private final AulaRepository aulaRepository;

    @Autowired
    public AulaService(AulaRepository aulaRepository) {
        this.aulaRepository = aulaRepository;
    }

    public List<AulaEntity>getAula(){
        return this.aulaRepository.findAll();
    }
    public ResponseEntity<Object> addNewAula(AulaEntity aula) {  
        HashMap<String, Object> datos = new HashMap<>();

        aulaRepository.save(aula);
        datos.put("datos", aula);
        datos.put("message", "Se creo el custodio correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    } 
}