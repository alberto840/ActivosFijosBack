package com.grupod.activosfijos.activo;
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
@RequestMapping(path = "api/v1/activo")
public class ActivoController {
    
    private final ActivoService activoService;

    @Autowired
    public ActivoController(ActivoService activoService) {
        this.activoService = activoService;
    }

    @GetMapping
    public List<ActivoEntity> getActivo(){
        return activoService.getActivo();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewActivo(@RequestBody ActivoEntity activo){
        return this.activoService.addNewActivo(activo);
    }
}
