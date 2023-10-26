package com.grupod.activosfijos.provincia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.grupod.activosfijos.custodio.CustodioEntity;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@Controller
@RestController
@RequestMapping("api/v1/provincias")
public class provinciaController {
    private final provinciaService provinciaService;

    @Autowired
    public provinciaController(provinciaService provinciaService){
        this.provinciaService = provinciaService;
    }
    @GetMapping
    public List<provinciaEntity> getAllProvincias() {
        return provinciaService.getAllProvincias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<provinciaEntity> getProvinciaById(@PathVariable Integer id) {
        Optional<provinciaEntity> provincia = provinciaService.getProvinciaById(id);
        return provincia.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<provinciaEntity> createProvincia(@RequestBody provinciaEntity provincia) {
        provinciaEntity savedProvincia = provinciaService.saveProvincia(provincia);
        return new ResponseEntity<>(savedProvincia, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<provinciaEntity> updateProvincia(@PathVariable Integer id, @RequestBody provinciaEntity provincia) {
        if (!provinciaService.getProvinciaById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        provincia.setId_provincia(id);
        provinciaEntity updatedProvincia = provinciaService.saveProvincia(provincia);
        return new ResponseEntity<>(updatedProvincia, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvincia(@PathVariable Integer id) {
        if (!provinciaService.getProvinciaById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        provinciaService.deleteProvincia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/list")
    public ResponseEntity<String> registrarNewProvincias(@RequestBody List<provinciaEntity> provincias) {
        for (provinciaEntity provincia : provincias) {

            // Llamar al servicio para agregar el Custodio
            this.provinciaService.saveProvincia(provincia);
        }

        return ResponseEntity.ok("Se recibieron y procesaron las provincias.");
    }
}
