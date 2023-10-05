package com.grupod.activosfijos.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/v1/paises")
public class paisController {
    private paisService paisService;
    @Autowired
    public paisController(paisService paisService){
        this.paisService = paisService;
    }
    @GetMapping
    public List<paisEntity> getAllPaises() {
        return paisService.getAllPaises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<paisEntity> getPaisById(@PathVariable Integer id) {
        Optional<paisEntity> pais = paisService.getPaisById(id);
        return pais.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<paisEntity> createPais(@RequestBody paisEntity pais) {
        paisEntity savedPais = paisService.savePais(pais);
        return new ResponseEntity<>(savedPais, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<paisEntity> updatePais(@PathVariable Integer id, @RequestBody paisEntity pais) {
        if (!paisService.getPaisById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pais.setId(id);
        paisEntity updatedPais = paisService.savePais(pais);
        return new ResponseEntity<>(updatedPais, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePais(@PathVariable Integer id) {
        if (!paisService.getPaisById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        paisService.deletePais(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
