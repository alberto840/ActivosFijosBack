package com.grupod.activosfijos.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grupod.activosfijos.marca.MarcaEntity;
import com.grupod.activosfijos.marca.MarcaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class paisService {
    private final PaisRepository paisRepository;
    @Autowired
    public paisService(PaisRepository paisRepository){
        this.paisRepository = paisRepository;
    }

    public List<paisEntity>getPais(){
        return this.paisRepository.findAll();
    }
    public ResponseEntity<Object> addNewPais(paisEntity pais) {  
        HashMap<String, Object> datos = new HashMap<>();

        paisRepository.save(pais);
        datos.put("datos", pais);
        datos.put("message", "Se creo el pais correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    } 
}
