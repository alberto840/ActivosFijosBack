package com.grupod.activosfijos.divisa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/monedas")
public class DivisasController {
    private final DivisasService divisasService;

    @Autowired
    public DivisasController(DivisasService divisasService) {
        this.divisasService = divisasService;
    }

    // Endpoint para obtener todas las monedas
    @GetMapping
    public List<DivisasEntity> getAllMonedas() {
        return divisasService.getAllMonedas();
    }

    // Endpoint para obtener una moneda por su ID
    @GetMapping("/{id}")
    public Optional<DivisasEntity> getMonedaById(@PathVariable Integer id) {
        return divisasService.getMonedaById(id);
    }

    // Endpoint para guardar moneda
    @PostMapping
    public DivisasEntity saveMoneda(@RequestBody DivisasEntity moneda) {
        return divisasService.saveMoneda(moneda);
    }

    // Endpoint para eliminar una moneda por su ID
    @DeleteMapping("/{id}")
    public void deleteMoneda(@PathVariable Integer id) {
        divisasService.deleteMoneda(id);
    }
}
