package com.grupod.activosfijos.usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @GetMapping
    public List<UsuarioEntity> getUsuario(){
        return usuarioService.getUsuario();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewUsuario(@RequestBody UsuarioEntity user){
        return this.usuarioService.addNewUsuario(user);
    }

    @PostMapping("/list")
    public ResponseEntity<String> registrarNewUsers(@RequestBody List<UsuarioEntity> users) {
        for (UsuarioEntity user : users) {
            this.usuarioService.addNewUsuario(user);
        }
        return ResponseEntity.ok("Se recibieron y procesaron users.");
    }
    
}
