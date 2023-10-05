package com.grupod.activosfijos.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class paisService {
    private final paisRepository paisRepository;
    @Autowired
    public paisService(paisRepository paisRepository){
        this.paisRepository = paisRepository;
    }
    public List<paisEntity> getAllPaises() {
        return paisRepository.findAll();
    }

    public Optional<paisEntity> getPaisById(Integer id) {
        return paisRepository.findById(id);
    }

    public paisEntity savePais(paisEntity pais) {
        return paisRepository.save(pais);
    }

    public void deletePais(Integer id) {
        paisRepository.deleteById(id);
    }
}
