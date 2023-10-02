package com.grupod.activosfijos.ubicacionActivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ubicacion-activo")
public class ubicacionActivoController {
    private final ubicacionActivoService ubicacionActivoService;

    @Autowired
    public ubicacionActivoController(ubicacionActivoService ubicacionActivoService){
        this.ubicacionActivoService = ubicacionActivoService;
    }
    @GetMapping("/all")
    public List<ubicacionActivoEntity> getAllUbicacionActivos() {
        return ubicacionActivoService.getAllUbicacionActivos();
    }

    @GetMapping("/{id}")
    public Optional<ubicacionActivoEntity> getUbicacionActivoById(@PathVariable Integer id) {
        return ubicacionActivoService.getUbicacionActivoById(id);
    }

    @PostMapping("/add")
    public ubicacionActivoEntity addUbicacionActivo(@RequestBody ubicacionActivoEntity ubicacionActivo) {
        return ubicacionActivoService.saveUbicacionActivo(ubicacionActivo);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUbicacionActivo(@PathVariable Integer id) {
        ubicacionActivoService.deleteUbicacionActivo(id);
    }
}
