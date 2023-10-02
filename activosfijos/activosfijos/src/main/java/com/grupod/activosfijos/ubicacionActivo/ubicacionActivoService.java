package com.grupod.activosfijos.ubicacionActivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ubicacionActivoService {
    public final ubicacionActivoRepository ubicacionActivoRepository;

    @Autowired
    public ubicacionActivoService (ubicacionActivoRepository ubicacionActivoRepository){
        this.ubicacionActivoRepository = ubicacionActivoRepository;
    }

    public List<ubicacionActivoEntity> getAllUbicacionActivos() {
        return ubicacionActivoRepository.findAll();
    }

    public Optional<ubicacionActivoEntity> getUbicacionActivoById(Integer id) {
        return ubicacionActivoRepository.findById(id);
    }

    public ubicacionActivoEntity saveUbicacionActivo(ubicacionActivoEntity ubicacionActivo) {
        return ubicacionActivoRepository.save(ubicacionActivo);
    }

    public void deleteUbicacionActivo(Integer id) {
        ubicacionActivoRepository.deleteById(id);
    }
}
