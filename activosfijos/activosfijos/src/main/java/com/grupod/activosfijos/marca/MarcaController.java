package com.grupod.activosfijos.marca;

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
@RequestMapping(path = "api/v1/marca")
public class MarcaController {
    private final MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }
    
    @GetMapping
    public List<MarcaEntity> getMarca(){
        return marcaService.getMarca();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewMarca(@RequestBody MarcaEntity marca){
        return this.marcaService.addNewMarca(marca);
    }
    @PostMapping("/list")
    public ResponseEntity<String> registrarNewMarcas(@RequestBody List<MarcaEntity> marcas) {
        for (MarcaEntity marca : marcas) {

            // Llamar al servicio para agregar el Custodio
            this.marcaService.addNewMarca(marca);
        }

        return ResponseEntity.ok("Se recibieron y procesaron marcas.");
    }
}
