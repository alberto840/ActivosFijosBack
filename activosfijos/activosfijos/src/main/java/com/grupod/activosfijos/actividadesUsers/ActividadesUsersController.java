package com.grupod.activosfijos.actividadesUsers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupod.activosfijos.aula.AulaEntity;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/registroActividades")
public class ActividadesUsersController {

    private final ActividadesUsersService actividadesUsersService;

    @Autowired
    public ActividadesUsersController(ActividadesUsersService actividadesUsersService) {
        this.actividadesUsersService = actividadesUsersService;
    }

    @GetMapping
    public List<ActividadesUsersEntity> getRegistro(){
        return actividadesUsersService.getActividad();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewRegistroActividad(@RequestBody ActividadesUsersEntity registro){
        return this.actividadesUsersService.addNewRegistroActividades(registro);
    }
    @PostMapping("/list")
    public ResponseEntity<String> registrarNewActividades(@RequestBody List<ActividadesUsersEntity> registros) {
        for (ActividadesUsersEntity registro : registros) {

            // Llamar al servicio para agregar el Custodio
            this.actividadesUsersService.addNewRegistroActividades(registro);
        }

        return ResponseEntity.ok("Se recibieron y procesaron registros.");
    }
}
