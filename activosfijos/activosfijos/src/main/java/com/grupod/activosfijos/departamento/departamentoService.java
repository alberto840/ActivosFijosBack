package com.grupod.activosfijos.departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class departamentoService {

    private final DepartamentoRepository departamentoRepository;

    @Autowired
    public departamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }
    public List<departamentoEntity> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    public Optional<departamentoEntity> getDepartamentoById(Integer id) {
        return departamentoRepository.findById(id);
    }

    public departamentoEntity saveDepartamento(departamentoEntity departamento) {
        return departamentoRepository.save(departamento);
    }

    public void deleteDepartamento(Integer id) {
        departamentoRepository.deleteById(id);
    }
}
