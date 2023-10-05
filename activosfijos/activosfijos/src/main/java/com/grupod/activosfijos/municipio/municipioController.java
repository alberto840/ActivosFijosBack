package com.grupod.activosfijos.municipio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/v1/municipios")
public class municipioController {
    private final municipioService municipioService;
    @Autowired
    public municipioController(municipioService municipioService){
        this.municipioService = municipioService;
    }
    @GetMapping
    public List<municipioEntity> getAllMunicipios() {
        return municipioService.getAllMunicipios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<municipioEntity> getMunicipioById(@PathVariable Integer id) {
        Optional<municipioEntity> municipio = municipioService.getMunicipioById(id);
        return municipio.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<municipioEntity> createMunicipio(@RequestBody municipioEntity municipio) {
        municipioEntity savedMunicipio = municipioService.saveMunicipio(municipio);
        return new ResponseEntity<>(savedMunicipio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<municipioEntity> updateMunicipio(@PathVariable Integer id, @RequestBody municipioEntity municipio) {
        if (!municipioService.getMunicipioById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        municipio.setId_municipio(id);
        municipioEntity updatedMunicipio = municipioService.saveMunicipio(municipio);
        return new ResponseEntity<>(updatedMunicipio, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMunicipio(@PathVariable Integer id) {
        if (!municipioService.getMunicipioById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        municipioService.deleteMunicipio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
