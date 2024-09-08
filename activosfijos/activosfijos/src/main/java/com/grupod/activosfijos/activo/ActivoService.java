package com.grupod.activosfijos.activo;

import com.grupod.activosfijos.aula.AulaEntity;
import com.grupod.activosfijos.bloque.BloqueEntity;
import com.grupod.activosfijos.categoria.CategoriaEntity;
import com.grupod.activosfijos.custodio.CustodioEntity;
import com.grupod.activosfijos.depreciacion.DepreciacionEntity;
import com.grupod.activosfijos.estadoActivo.EstadoactivoEntity;
import com.grupod.activosfijos.identificador.IdentificadorEntity;
import com.grupod.activosfijos.proyecto.ProyectoEntity;
import com.grupod.activosfijos.utils.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivoService {

    private static final Logger logger = LoggerFactory.getLogger(ActivoService.class);
    private final ActivoRepository activoRepository;

    @Autowired
    public ActivoService(ActivoRepository activoRepository) {
        this.activoRepository = activoRepository;
    }

    public ActivoDto crearActivo(ActivoDto activoDto) {
        logger.info("Creando nuevo activo: {}", activoDto.getNombre());
        ActivoEntity activoEntity = convertirDtoAEntidad(activoDto);
        ActivoEntity nuevoActivo = activoRepository.save(activoEntity);
        return convertirEntidadADto(nuevoActivo);
    }

    public List<ActivoDto> obtenerTodosLosActivos() {
        logger.info("Obteniendo todos los activos");
        List<ActivoEntity> activos = activoRepository.findAll();
        return activos.stream().map(this::convertirEntidadADto).collect(Collectors.toList());
    }

    public ActivoDto obtenerActivoPorId(Integer id) {
        logger.info("Obteniendo activo con ID: {}", id);
        ActivoEntity activo = activoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activo no encontrado con ID: " + id));
        return convertirEntidadADto(activo);
    }

    public ActivoDto actualizarActivo(Integer id, ActivoDto activoDto) {
        logger.info("Actualizando activo con ID: {}", id);
        ActivoEntity activoEntity = activoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activo no encontrado con ID: " + id));

        activoEntity.setNombre(activoDto.getNombre());
        activoEntity.setValorActual(activoDto.getValorActual());
        activoEntity.setValorInicial(activoDto.getValorInicial());
        activoEntity.setFechaRegistro(activoDto.getFechaRegistro());
        activoEntity.setDetalle(activoDto.getDetalle());
        activoEntity.setEstado(activoDto.getEstado());
        activoEntity.setPrecio(activoDto.getPrecio());
        activoEntity.setComprobanteCompra(activoDto.getComprobanteCompra());

        ActivoEntity activoActualizado = activoRepository.save(activoEntity);
        return convertirEntidadADto(activoActualizado);
    }

    public void eliminarActivo(Integer id) {
        logger.info("Eliminando activo con ID: {}", id);
        if (!activoRepository.existsById(id)) {
            throw new RuntimeException("Activo no encontrado con ID: " + id);
        }
        activoRepository.deleteById(id);
    }

    private ActivoEntity convertirDtoAEntidad(ActivoDto activoDto) {
        ActivoEntity activoEntity = new ActivoEntity();

        // Asignar valores simples
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

        if (activoDto.getIdIdentificador() != null) {
            IdentificadorEntity identificador = new IdentificadorEntity();
            identificador.setIdIdentificador(activoDto.getIdIdentificador());
            activoEntity.setIdentificadorEntity(identificador);
        }

        if (activoDto.getIdProyecto() != null) {
            ProyectoEntity proyecto = new ProyectoEntity();
            proyecto.setIdProyecto(activoDto.getIdProyecto());
            activoEntity.setProyectoEntity(proyecto);
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
                activoEntity.getIdentificadorEntity() != null ? activoEntity.getIdentificadorEntity().getIdIdentificador() : null,
                activoEntity.getProyectoEntity() != null ? activoEntity.getProyectoEntity().getIdProyecto() : null
        );
    }

}
