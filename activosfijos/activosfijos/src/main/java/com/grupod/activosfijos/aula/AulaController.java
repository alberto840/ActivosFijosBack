package com.grupod.activosfijos.aula;
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
@RequestMapping(path = "api/v1/aula")
public class AulaController {
    private final AulaService aulaService;

    @Autowired
    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }
    
    @GetMapping
    public List<AulaEntity> getAula(){
        return aulaService.getAula();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewAula(@RequestBody AulaEntity aula){
        return this.aulaService.addNewAula(aula);
    }
    @PostMapping("/list")
    public ResponseEntity<String> registrarNewAulas(@RequestBody List<AulaEntity> aulas) {
        for (AulaEntity aula : aulas) {

            // Llamar al servicio para agregar el Custodio
            this.aulaService.addNewAula(aula);
        }

        return ResponseEntity.ok("Se recibieron y procesaron aulas.");
    }
}
