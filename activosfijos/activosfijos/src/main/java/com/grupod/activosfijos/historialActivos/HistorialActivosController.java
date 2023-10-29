package com.grupod.activosfijos.historialActivos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/historialActivos")
public class HistorialActivosController {
    private final HistorialACtivosService historialService;

    @Autowired
    public HistorialActivosController(HistorialACtivosService historialService) {
        this.historialService = historialService;
    }
    
    @GetMapping
    public List<HistorialActivosEntity> getHistorial(){
        return historialService.getHistorial();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewHistorial(@RequestBody HistorialActivosEntity historial){
        return this.historialService.addNewHistorial(historial);
    }
}
