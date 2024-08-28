package com.grupod.activosfijos.divisa;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivisasService {
    private final DivisasRepository divisasRepository;
    @Autowired
    public DivisasService(DivisasRepository divisasRepository){
        this.divisasRepository = divisasRepository;
    }
    // Método para obtener todas las monedas
    public List<DivisasEntity> getAllMonedas() {
        return divisasRepository.findAll();
    }

    // Método para obtener una moneda por su ID
    public Optional<DivisasEntity> getMonedaById(Integer id) {
        return divisasRepository.findById(id);
    }

    // Método para guardar una moneda
    public DivisasEntity saveMoneda(DivisasEntity moneda) {
        return divisasRepository.save(moneda);
    }

    // Método para eliminar una moneda por su ID
    public void deleteMoneda(Integer id) {
        divisasRepository.deleteById(id);
    }

}
