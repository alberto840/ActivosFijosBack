package com.grupod.activosfijos.municipio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class municipioService {
    private municipioRepository municipioRepository;
    @Autowired
    public municipioService(municipioRepository municipioRepository){
        this.municipioRepository = municipioRepository;
    }
    public List<municipioEntity> getAllMunicipios() {
        return municipioRepository.findAll();
    }

    public Optional<municipioEntity> getMunicipioById(Integer id) {
        return municipioRepository.findById(id);
    }

    public municipioEntity saveMunicipio(municipioEntity municipio) {
        return municipioRepository.save(municipio);
    }

    public void deleteMunicipio(Integer id) {
        municipioRepository.deleteById(id);
    }
}
