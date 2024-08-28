package com.grupod.activosfijos.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    @Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }
    public List<DepartamentoEntity> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Optional<DepartamentoEntity> getDepartamentoById(Integer id) {
        return departamentoRepository.findById(id);
    }

    public DepartamentoEntity saveDepartamento(DepartamentoEntity departamento) {
        return departamentoRepository.save(departamento);
    }

    public void deleteDepartamento(Integer id) {
        departamentoRepository.deleteById(id);
    }
}
