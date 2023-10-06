package com.grupod.activosfijos.unidad;
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
@RequestMapping(path = "api/v1/unidad")
public class UnidadController {
    private final UnidadService unidadService;

    @Autowired
    public UnidadController(UnidadService unidadService) {
        this.unidadService = unidadService;
    }
    
    @GetMapping
    public List<UnidadEntity> getUnidad(){
        return unidadService.getUnidad();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewUnidad(@RequestBody UnidadEntity unidad){
        return this.unidadService.addNewUnidad(unidad);
    }
}
