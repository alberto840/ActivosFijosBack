package com.grupod.activosfijos.usuario;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grupod.activosfijos.marca.MarcaEntity;
import com.grupod.activosfijos.marca.MarcaRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioEntity>getUsuario(){
        return this.usuarioRepository.findAll();
    }
    public ResponseEntity<Object> addNewUsuario(UsuarioEntity user) {  
        HashMap<String, Object> datos = new HashMap<>();

        usuarioRepository.save(user);
        datos.put("datos", user);
        datos.put("message", "Se creo el usuario correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    } 
}
