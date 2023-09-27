package com.grupod.activosfijos.marca;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MarcaService {
    private final MarcaRepository marcaRepository;

    @Autowired
    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public List<MarcaEntity>getMarca(){
        return this.marcaRepository.findAll();
    }
    public ResponseEntity<Object> addNewMarca(MarcaEntity marca) {  
        HashMap<String, Object> datos = new HashMap<>();

        marcaRepository.save(marca);
        datos.put("datos", marca);
        datos.put("message", "Se creo la marca correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    } 
}
