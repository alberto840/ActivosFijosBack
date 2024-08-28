package com.grupod.activosfijos.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/v1/departamentos")
public class DepartamentoController {
    private DepartamentoService departamentoService;

    @Autowired
    public DepartamentoController(DepartamentoService departamentoService){
        this.departamentoService = departamentoService;
    }
    @GetMapping
    public List<DepartamentoEntity> getCustodio(){
        return departamentoService.getAllDepartamentos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoEntity> getDepartamentoById(@PathVariable Integer id) {
        Optional<DepartamentoEntity> departamento = departamentoService.getDepartamentoById(id);
        return departamento.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DepartamentoEntity> createDepartamento(@RequestBody DepartamentoEntity departamento) {
        DepartamentoEntity savedDepartamento = departamentoService.saveDepartamento(departamento);
        return new ResponseEntity<>(savedDepartamento, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoEntity> updateDepartamento(@PathVariable Integer id, @RequestBody DepartamentoEntity departamento) {
        if (!departamentoService.getDepartamentoById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        departamento.setId_departamento(id);
        DepartamentoEntity updatedDepartamento = departamentoService.saveDepartamento(departamento);
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
    @PostMapping("/list")
    public ResponseEntity<String> registrarNewDepartamentos(@RequestBody List<DepartamentoEntity> departamentos) {
        for (DepartamentoEntity departamento : departamentos) {

            // Llamar al servicio para agregar el Custodio
            this.departamentoService.saveDepartamento(departamento);
        }

        return ResponseEntity.ok("Se recibieron y procesaron los departamentos.");
    }
}
