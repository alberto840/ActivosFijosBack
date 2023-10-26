package com.grupod.activosfijos.custodio;

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
@RequestMapping(path = "api/v1/custodio")
public class CustodioController {
    
    private final CustodioService custodioService;

    @Autowired
    public CustodioController(CustodioService custodioService) {
        this.custodioService = custodioService;
    }
    
    @GetMapping
    public List<CustodioEntity> getCustodio(){
        return custodioService.getCustodio();
    }

    @PostMapping
        public ResponseEntity<Object> registerNewCustodio(@RequestBody CustodioEntity custodio){
        return this.custodioService.addNewCustodio(custodio);
    }

    @PostMapping("/list")
    public ResponseEntity<String> registrarNewCustodios(@RequestBody List<CustodioEntity> custodios) {
        for (CustodioEntity custodio : custodios) {

            // Llamar al servicio para agregar el Custodio
            this.custodioService.addNewCustodio(custodio);
        }

        return ResponseEntity.ok("Se recibieron y procesaron las personas.");
    }
}
