package com.grupod.activosfijos.historialActivos;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HistorialACtivosService {
    private final HistorialActivosRepository historialActivosRepository;

    @Autowired
    public HistorialACtivosService(HistorialActivosRepository historialActivosRepository) {
        this.historialActivosRepository = historialActivosRepository;
    }

    public List<HistorialActivosEntity>getHistorial(){
        return this.historialActivosRepository.findAll();
    }
    public ResponseEntity<Object> addNewHistorial(HistorialActivosEntity historial) {  
        HashMap<String, Object> datos = new HashMap<>();

        historialActivosRepository.save(historial);
        datos.put("datos", historial);
        datos.put("message", "Se creo el historial correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    } 
}
