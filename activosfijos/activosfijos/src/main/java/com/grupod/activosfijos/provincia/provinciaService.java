package com.grupod.activosfijos.provincia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class provinciaService {
    private final provinciaRepository provinciaRepository;
    @Autowired
    public provinciaService (provinciaRepository provinciaRepository){
        this.provinciaRepository = provinciaRepository;
    }
    public List<provinciaEntity> getAllProvincias() {
        return provinciaRepository.findAll();
    }

    public Optional<provinciaEntity> getProvinciaById(Integer id) {
        return provinciaRepository.findById(id);
    }

    public provinciaEntity saveProvincia(provinciaEntity provincia) {
        return provinciaRepository.save(provincia);
    }

    public void deleteProvincia(Integer id) {
        provinciaRepository.deleteById(id);
    }
}
