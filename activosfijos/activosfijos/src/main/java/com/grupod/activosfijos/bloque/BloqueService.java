package com.grupod.activosfijos.bloque;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BloqueService {
    private final BloqueRepository bloqueRepository;

    @Autowired
    public BloqueService(BloqueRepository bloqueRepository) {
        this.bloqueRepository = bloqueRepository;
    }

    public List<BloqueEntity>getBloque(){
        return this.bloqueRepository.findAll();
    }
    public ResponseEntity<Object> addNewBloque(BloqueEntity bloque) {  
        HashMap<String, Object> datos = new HashMap<>();

        bloqueRepository.save(bloque);
        datos.put("datos", bloque);
        datos.put("message", "Se creo el custodio correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }
}
