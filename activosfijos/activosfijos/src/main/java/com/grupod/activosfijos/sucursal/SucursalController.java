package com.grupod.activosfijos.sucursal;

import com.grupod.activosfijos.utils.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sucursales")
public class SucursalController {

    private static final Logger logger = LoggerFactory.getLogger(SucursalController.class);

    private final SucursalService sucursalService;

    @Autowired
    public SucursalController(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    @PostMapping("/crear")
    public ResponseEntity<ResponseDto<SucursalDto>> crearSucursal(@RequestBody SucursalDto sucursalDto) {
        logger.info("Solicitud para crear sucursal recibida");
        SucursalDto nuevaSucursal = sucursalService.crearSucursal(sucursalDto);
        return ResponseEntity.ok(new ResponseDto<>(true, "Sucursal creada exitosamente", nuevaSucursal));
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<SucursalDto>>> obtenerTodasLasSucursales() {
        logger.info("Solicitud para obtener todas las sucursales recibida");
        List<SucursalDto> sucursales = sucursalService.obtenerTodasLasSucursales();
        return ResponseEntity.ok(new ResponseDto<>(true, "Sucursales obtenidas exitosamente", sucursales));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<SucursalDto>> obtenerSucursalPorId(@PathVariable Integer id) {
        logger.info("Solicitud para obtener sucursal con ID {} recibida", id);
        SucursalDto sucursal = sucursalService.obtenerSucursalPorId(id);
        return ResponseEntity.ok(new ResponseDto<>(true, "Sucursal obtenida exitosamente", sucursal));
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ResponseDto<SucursalDto>> actualizarSucursal(@PathVariable Integer id, @RequestBody SucursalDto sucursalDto) {
        logger.info("Solicitud para actualizar sucursal con ID {} recibida", id);
        SucursalDto sucursalActualizada = sucursalService.actualizarSucursal(id, sucursalDto);
        return ResponseEntity.ok(new ResponseDto<>(true, "Sucursal actualizada exitosamente", sucursalActualizada));
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ResponseDto<Void>> eliminarSucursal(@PathVariable Integer id) {
        logger.info("Solicitud para eliminar sucursal con ID {} recibida", id);
        sucursalService.eliminarSucursal(id);
        return ResponseEntity.ok(new ResponseDto<>(true, "Sucursal eliminada exitosamente", null));
    }
}
