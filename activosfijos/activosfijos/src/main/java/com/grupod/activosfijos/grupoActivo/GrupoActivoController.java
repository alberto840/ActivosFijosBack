package com.grupod.activosfijos.grupoActivo;
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
@RequestMapping(path = "api/v1/grupoActivo")
public class GrupoActivoController {
    private final GrupoActivoService grupoActivoService;

    @Autowired
    public GrupoActivoController(GrupoActivoService grupoActivoService) {
        this.grupoActivoService = grupoActivoService;
    }
    
    @GetMapping
    public List<GrupoActivoEntity> getGrupoActivo(){
        return grupoActivoService.getGrupoActivo();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewGrupoActivo(@RequestBody GrupoActivoEntity grupoActivo){
        return this.grupoActivoService.addNewGrupoActivo(grupoActivo);
    }
}
