package com.grupod.activosfijos.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.grupod.activosfijos.custodio.CustodioEntity;
import com.grupod.activosfijos.marca.MarcaEntity;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller
@RestController
@RequestMapping(path = "api/v1/pais")
public class paisController {
    private paisService paisService;
    @Autowired
    public paisController(paisService paisService){
        this.paisService = paisService;
    }

    @GetMapping
    public List<paisEntity> getPais(){
        return paisService.getPais();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewPais(@RequestBody paisEntity pais){
        return this.paisService.addNewPais(pais);
    }
    @PostMapping("/list")
    public ResponseEntity<String> registrarNewPaises(@RequestBody List<paisEntity> paises) {
        for (paisEntity pais : paises) {

            // Llamar al servicio para agregar el Custodio
            this.paisService.addNewPais(pais);
        }

        return ResponseEntity.ok("Se recibieron y procesaron los paises.");
    }
}
