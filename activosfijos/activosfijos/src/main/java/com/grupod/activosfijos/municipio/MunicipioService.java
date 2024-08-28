package com.grupod.activosfijos.municipio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService {
    private MunicipioRepository municipioRepository;
    @Autowired
    public MunicipioService(MunicipioRepository municipioRepository){
        this.municipioRepository = municipioRepository;
    }
    public List<MunicipioEntity> getAllMunicipios() {
        return municipioRepository.findAll();
    }

    public Optional<MunicipioEntity> getMunicipioById(Integer id) {
        return municipioRepository.findById(id);
    }

    public MunicipioEntity saveMunicipio(MunicipioEntity municipio) {
        return municipioRepository.save(municipio);
    }

    public void deleteMunicipio(Integer id) {
        municipioRepository.deleteById(id);
    }
}
