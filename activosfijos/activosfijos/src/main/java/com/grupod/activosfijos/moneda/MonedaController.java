package com.grupod.activosfijos.moneda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/monedas")
public class MonedaController {
    private final MonedaService monedaService;

    @Autowired
    public MonedaController(MonedaService monedaService) {
        this.monedaService = monedaService;
    }

    // Endpoint para obtener todas las monedas
    @GetMapping
    public List<MonedaEntity> getAllMonedas() {
        return monedaService.getAllMonedas();
    }

    // Endpoint para obtener una moneda por su ID
    @GetMapping("/{id}")
    public Optional<MonedaEntity> getMonedaById(@PathVariable Integer id) {
        return monedaService.getMonedaById(id);
    }

    // Endpoint para guardar moneda
    @PostMapping
    public MonedaEntity saveMoneda(@RequestBody MonedaEntity moneda) {
        return monedaService.saveMoneda(moneda);
    }

    // Endpoint para eliminar una moneda por su ID
    @DeleteMapping("/{id}")
    public void deleteMoneda(@PathVariable Integer id) {
        monedaService.deleteMoneda(id);
    }
}
