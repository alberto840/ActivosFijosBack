package com.grupod.activosfijos.direccion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupod.activosfijos.marca.MarcaEntity;
import com.grupod.activosfijos.marca.MarcaService;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/direccion")
public class DireccionController {
    private final DireccionService direccionService;

    @Autowired
    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }
    
    @GetMapping
    public List<DireccionEntity> getDireccion(){
        return direccionService.getDireccion();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewDireccion(@RequestBody DireccionEntity direccion){
        return this.direccionService.addNewDireccion(direccion);
    }
}
