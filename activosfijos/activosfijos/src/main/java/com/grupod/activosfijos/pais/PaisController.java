package com.grupod.activosfijos.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
@RestController
@RequestMapping(path = "api/v1/pais")
public class PaisController {
    private PaisService paisService;
    @Autowired
    public PaisController(PaisService paisService){
        this.paisService = paisService;
    }

    @GetMapping
    public List<PaisEntity> getPais(){
        return paisService.getPais();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewPais(@RequestBody PaisEntity pais){
        return this.paisService.addNewPais(pais);
    }
    @PostMapping("/list")
    public ResponseEntity<String> registrarNewPaises(@RequestBody List<PaisEntity> paises) {
        for (PaisEntity pais : paises) {

            // Llamar al servicio para agregar el Custodio
            this.paisService.addNewPais(pais);
        }

        return ResponseEntity.ok("Se recibieron y procesaron los paises.");
    }
}
