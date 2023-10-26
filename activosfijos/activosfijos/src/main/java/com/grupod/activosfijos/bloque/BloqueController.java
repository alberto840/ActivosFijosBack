package com.grupod.activosfijos.bloque;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupod.activosfijos.aula.AulaEntity;
import com.grupod.activosfijos.aula.AulaService;
import com.grupod.activosfijos.direccion.DireccionEntity;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/bloque")
public class BloqueController {
    private final BloqueService bloqueService;

    @Autowired
    public BloqueController(BloqueService bloqueService) {
        this.bloqueService = bloqueService;
    }
    
    @GetMapping
    public List<BloqueEntity> getBloque(){
        return bloqueService.getBloque();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewBloque(@RequestBody BloqueEntity bloque){
        return this.bloqueService.addNewBloque(bloque);
    }
    @PostMapping("/list")
    public ResponseEntity<String> registrarNewBloques(@RequestBody List<BloqueEntity> bloques) {
        for (BloqueEntity bloque : bloques) {

            // Llamar al servicio para agregar el Custodio
            this.bloqueService.addNewBloque(bloque);
        }

        return ResponseEntity.ok("Se recibieron y procesaron bloques.");
    }
}
