package com.grupod.activosfijos.activo;

import com.grupod.activosfijos.aula.AulaEntity;
import com.grupod.activosfijos.bloque.BloqueEntity;
import com.grupod.activosfijos.categoria.CategoriaEntity;
import com.grupod.activosfijos.custodio.CustodioEntity;
import com.grupod.activosfijos.depreciacion.DepreciacionEntity;
import com.grupod.activosfijos.estadoActivo.EstadoactivoEntity;
import com.grupod.activosfijos.modelo.ModeloEntity; // Importación de ModeloEntity
import com.grupod.activosfijos.proyecto.ProyectoEntity;
import com.grupod.activosfijos.utils.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActivoService {

    private static final Logger logger = LoggerFactory.getLogger(ActivoService.class);
    private final ActivoRepository activoRepository;

    @Autowired
    public ActivoService(ActivoRepository activoRepository) {
        this.activoRepository = activoRepository;
    }

    public ResponseEntity<ResponseDto<ActivoDto>> crearActivo(ActivoDto activoDto) {
        logger.info("Creando nuevo activo: {}", activoDto.getNombre());
        ActivoEntity activoEntity = convertirDtoAEntidad(activoDto);
        ActivoEntity nuevoActivo = activoRepository.save(activoEntity);
        ActivoDto nuevoActivoDto = convertirEntidadADto(nuevoActivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto<>(true, "Activo creado exitosamente", nuevoActivoDto));
    }

    public ResponseEntity<ResponseDto<List<ActivoDto>>> obtenerTodosLosActivos() {
        logger.info("Obteniendo todos los activos");
        List<ActivoEntity> activos = activoRepository.findAll();
        List<ActivoDto> activosDto = activos.stream().map(this::convertirEntidadADto).collect(Collectors.toList());
        return ResponseEntity.ok(new ResponseDto<>(true, "Activos obtenidos exitosamente", activosDto));
    }

    public ResponseEntity<ResponseDto<ActivoDto>> obtenerActivoPorId(Integer id) {
        logger.info("Obteniendo activo con ID: {}", id);
        Optional<ActivoEntity> activoOpt = activoRepository.findById(id);
        if (activoOpt.isEmpty()) {
            logger.warn("Activo con ID {} no encontrado", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto<>(false, "Activo no encontrado", null));
        }
        ActivoDto activoDto = convertirEntidadADto(activoOpt.get());
        return ResponseEntity.ok(new ResponseDto<>(true, "Activo obtenido exitosamente", activoDto));
    }

    public ResponseEntity<ResponseDto<ActivoDto>> actualizarActivo(Integer id, ActivoDto activoDto) {
        logger.info("Actualizando activo con ID: {}", id);
        Optional<ActivoEntity> activoOpt = activoRepository.findById(id);
        if (activoOpt.isEmpty()) {
            logger.warn("Activo con ID {} no encontrado", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto<>(false, "Activo no encontrado", null));
        }

        ActivoEntity activoEntity = activoOpt.get();
        activoEntity.setNombre(activoDto.getNombre());
        activoEntity.setValorActual(activoDto.getValorActual());
        activoEntity.setValorInicial(activoDto.getValorInicial());
        activoEntity.setFechaRegistro(activoDto.getFechaRegistro());
        activoEntity.setDetalle(activoDto.getDetalle());
        activoEntity.setEstado(activoDto.getEstado());
        activoEntity.setPrecio(activoDto.getPrecio());
        activoEntity.setComprobanteCompra(activoDto.getComprobanteCompra());

        // Actualizar la relación con Modelo si el ID de modelo se proporciona
        if (activoDto.getIdModelo() != null) {
            ModeloEntity modeloEntity = new ModeloEntity();
            modeloEntity.setIdModelo(activoDto.getIdModelo());
            activoEntity.setModeloEntity(modeloEntity);
        }

        ActivoEntity activoActualizado = activoRepository.save(activoEntity);
        ActivoDto activoActualizadoDto = convertirEntidadADto(activoActualizado);
        return ResponseEntity.ok(new ResponseDto<>(true, "Activo actualizado exitosamente", activoActualizadoDto));
    }

    public ResponseEntity<ResponseDto<Void>> eliminarActivo(Integer id) {
        logger.info("Eliminando activo con ID: {}", id);
        if (!activoRepository.existsById(id)) {
            logger.warn("Activo con ID {} no encontrado", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDto<>(false, "Activo no encontrado", null));
        }
        activoRepository.deleteById(id);
        logger.info("Activo con ID {} eliminado exitosamente", id);
        return ResponseEntity.ok(new ResponseDto<>(true, "Activo eliminado exitosamente", null));
    }

    private ActivoEntity convertirDtoAEntidad(ActivoDto activoDto) {
        ActivoEntity activoEntity = new ActivoEntity();
        activoEntity.setNombre(activoDto.getNombre());
        activoEntity.setValorActual(activoDto.getValorActual());
        activoEntity.setValorInicial(activoDto.getValorInicial());
        activoEntity.setFechaRegistro(activoDto.getFechaRegistro());
        activoEntity.setDetalle(activoDto.getDetalle());
        activoEntity.setEstado(activoDto.getEstado());
        activoEntity.setPrecio(activoDto.getPrecio());
        activoEntity.setComprobanteCompra(activoDto.getComprobanteCompra());

        // Asignar entidades relacionadas si los IDs no son nulos
        if (activoDto.getIdAula() != null) {
            AulaEntity aula = new AulaEntity();
            aula.setIdAula(activoDto.getIdAula());
            activoEntity.setAulaEntity(aula);
        }

        if (activoDto.getIdBloque() != null) {
            BloqueEntity bloque = new BloqueEntity();
            bloque.setIdBloque(activoDto.getIdBloque());
            activoEntity.setBloqueEntity(bloque);
        }

        if (activoDto.getIdCategoria() != null) {
            CategoriaEntity categoria = new CategoriaEntity();
            categoria.setIdCategoria(activoDto.getIdCategoria());
            activoEntity.setCategoriaEntity(categoria);
        }

        if (activoDto.getIdCustodio() != null) {
            CustodioEntity custodio = new CustodioEntity();
            custodio.setIdCustodio(activoDto.getIdCustodio());
            activoEntity.setCustodioEntity(custodio);
        }

        if (activoDto.getIdDepreciacion() != null) {
            DepreciacionEntity depreciacion = new DepreciacionEntity();
            depreciacion.setIdDepreciacion(activoDto.getIdDepreciacion());
            activoEntity.setDepreciacionEntity(depreciacion);
        }

        if (activoDto.getIdEstadoactivo() != null) {
            EstadoactivoEntity estadoactivo = new EstadoactivoEntity();
            estadoactivo.setIdEstado(activoDto.getIdEstadoactivo());
            activoEntity.setEstadoactivoEntity(estadoactivo);
        }

        if (activoDto.getIdProyecto() != null) {
            ProyectoEntity proyecto = new ProyectoEntity();
            proyecto.setIdProyecto(activoDto.getIdProyecto());
            activoEntity.setProyectoEntity(proyecto);
        }

        if (activoDto.getIdModelo() != null) {
            ModeloEntity modelo = new ModeloEntity();
            modelo.setIdModelo(activoDto.getIdModelo());
            activoEntity.setModeloEntity(modelo);
        }

        return activoEntity;
    }

    private ActivoDto convertirEntidadADto(ActivoEntity activoEntity) {
        return new ActivoDto(
                activoEntity.getIdActivo(),
                activoEntity.getNombre(),
                activoEntity.getValorActual(),
                activoEntity.getValorInicial(),
                activoEntity.getFechaRegistro(),
                activoEntity.getDetalle(),
                activoEntity.isEstado(),
                activoEntity.getPrecio(),
                activoEntity.getComprobanteCompra(),
                activoEntity.getAulaEntity() != null ? activoEntity.getAulaEntity().getIdAula() : null,
                activoEntity.getBloqueEntity() != null ? activoEntity.getBloqueEntity().getIdBloque() : null,
                activoEntity.getCategoriaEntity() != null ? activoEntity.getCategoriaEntity().getIdCategoria() : null,
                activoEntity.getCustodioEntity() != null ? activoEntity.getCustodioEntity().getIdCustodio() : null,
                activoEntity.getDepreciacionEntity() != null ? activoEntity.getDepreciacionEntity().getIdDepreciacion() : null,
                activoEntity.getEstadoactivoEntity() != null ? activoEntity.getEstadoactivoEntity().getIdEstado() : null,
                activoEntity.getProyectoEntity() != null ? activoEntity.getProyectoEntity().getIdProyecto() : null,
                activoEntity.getModeloEntity() != null ? activoEntity.getModeloEntity().getIdModelo() : null
        );
    }

}
