package com.grupod.activosfijos.grupoActivo;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GrupoActivoService {
    private final GrupoActivoRepository grupoActivoRepository;

    @Autowired
    public GrupoActivoService(GrupoActivoRepository grupoActivoRepository) {
        this.grupoActivoRepository = grupoActivoRepository;
    }

    public List<GrupoActivoEntity>getGrupoActivo(){
        return this.grupoActivoRepository.findAll();
    }
    public ResponseEntity<Object> addNewGrupoActivo(GrupoActivoEntity grupoActivo) {  
        HashMap<String, Object> datos = new HashMap<>();

        grupoActivoRepository.save(grupoActivo);
        datos.put("datos", grupoActivo);
        datos.put("message", "Se creo el grupo de activos correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }
}
