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
public class MunicipioController {
    private final MunicipioService municipioService;
    @Autowired
    public MunicipioController(MunicipioService municipioService){
        this.municipioService = municipioService;
    }
    @GetMapping
    public List<MunicipioEntity> getAllMunicipios() {
        return municipioService.getAllMunicipios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MunicipioEntity> getMunicipioById(@PathVariable Integer id) {
        Optional<MunicipioEntity> municipio = municipioService.getMunicipioById(id);
        return municipio.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<MunicipioEntity> createMunicipio(@RequestBody MunicipioEntity municipio) {
        MunicipioEntity savedMunicipio = municipioService.saveMunicipio(municipio);
        return new ResponseEntity<>(savedMunicipio, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MunicipioEntity> updateMunicipio(@PathVariable Integer id, @RequestBody MunicipioEntity municipio) {
        if (!municipioService.getMunicipioById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        municipio.setId_municipio(id);
        MunicipioEntity updatedMunicipio = municipioService.saveMunicipio(municipio);
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
