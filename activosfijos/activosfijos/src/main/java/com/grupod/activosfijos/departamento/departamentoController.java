package com.grupod.activosfijos.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/departamentos")
public class departamentoController {
    private departamentoService departamentoService;

    @Autowired
    public departamentoController(departamentoService departamentoService){
        this.departamentoService = departamentoService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<departamentoEntity> getDepartamentoById(@PathVariable Integer id) {
        Optional<departamentoEntity> departamento = departamentoService.getDepartamentoById(id);
        return departamento.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<departamentoEntity> createDepartamento(@RequestBody departamentoEntity departamento) {
        departamentoEntity savedDepartamento = departamentoService.saveDepartamento(departamento);
        return new ResponseEntity<>(savedDepartamento, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<departamentoEntity> updateDepartamento(@PathVariable Integer id, @RequestBody departamentoEntity departamento) {
        if (!departamentoService.getDepartamentoById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        departamento.setId_departamento(id);
        departamentoEntity updatedDepartamento = departamentoService.saveDepartamento(departamento);
        return new ResponseEntity<>(updatedDepartamento, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartamento(@PathVariable Integer id) {
        if (!departamentoService.getDepartamentoById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        departamentoService.deleteDepartamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
