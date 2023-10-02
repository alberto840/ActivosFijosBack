package com.grupod.activosfijos.moneda;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonedaService {
    private final MonedaRepository monedaRepository;
    @Autowired
    public MonedaService(MonedaRepository monedaRepository){
        this.monedaRepository = monedaRepository;
    }
    // Método para obtener todas las monedas
    public List<MonedaEntity> getAllMonedas() {
        return monedaRepository.findAll();
    }

    // Método para obtener una moneda por su ID
    public Optional<MonedaEntity> getMonedaById(Integer id) {
        return monedaRepository.findById(id);
    }

    // Método para guardar una moneda
    public MonedaEntity saveMoneda(MonedaEntity moneda) {
        return monedaRepository.save(moneda);
    }

    // Método para eliminar una moneda por su ID
    public void deleteMoneda(Integer id) {
        monedaRepository.deleteById(id);
    }

}
