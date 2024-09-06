package com.grupod.activosfijos.identificador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IdentificadorService {

    private static final Logger logger = LoggerFactory.getLogger(IdentificadorService.class);
    private final IdentificadorRepository identificadorRepository;

    @Autowired
    public IdentificadorService(IdentificadorRepository identificadorRepository) {
        this.identificadorRepository = identificadorRepository;
    }

    public IdentificadorDto crearIdentificador(IdentificadorDto identificadorDto) {
        logger.info("Creando identificador con código QR: {}", identificadorDto.getCodigoQr());

        IdentificadorEntity identificadorEntity = new IdentificadorEntity(
                null,
                identificadorDto.getCodigoQr(),
                identificadorDto.getCodigoBarra()
        );

        IdentificadorEntity nuevoIdentificador = identificadorRepository.save(identificadorEntity);
        logger.info("Identificador creado con ID: {}", nuevoIdentificador.getIdIdentificador());

        return convertirAIdentificadorDto(nuevoIdentificador);
    }

    public List<IdentificadorDto> obtenerTodosLosIdentificadores() {
        logger.info("Obteniendo todos los identificadores");
        return identificadorRepository.findAll()
                .stream()
                .map(this::convertirAIdentificadorDto)
                .collect(Collectors.toList());
    }

    public IdentificadorDto obtenerIdentificadorPorId(Integer id) {
        logger.info("Obteniendo identificador con ID: {}", id);
        IdentificadorEntity identificadorEntity = identificadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Identificador no encontrado"));

        return convertirAIdentificadorDto(identificadorEntity);
    }

    public IdentificadorDto actualizarIdentificador(Integer id, IdentificadorDto identificadorDto) {
        logger.info("Actualizando identificador con ID: {}", id);

        IdentificadorEntity identificadorEntity = identificadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Identificador no encontrado"));

        identificadorEntity.setCodigoQr(identificadorDto.getCodigoQr());
        identificadorEntity.setCodigoBarra(identificadorDto.getCodigoBarra());

        IdentificadorEntity identificadorActualizado = identificadorRepository.save(identificadorEntity);
        logger.info("Identificador actualizado con ID: {}", identificadorActualizado.getIdIdentificador());

        return convertirAIdentificadorDto(identificadorActualizado);
    }

    public void eliminarIdentificador(Integer id) {
        logger.info("Eliminando identificador con ID: {}", id);
        if (!identificadorRepository.existsById(id)) {
            throw new RuntimeException("Identificador no encontrado");
        }
        identificadorRepository.deleteById(id);
    }

    private IdentificadorDto convertirAIdentificadorDto(IdentificadorEntity identificadorEntity) {
        return new IdentificadorDto(
                identificadorEntity.getIdIdentificador(),
                identificadorEntity.getCodigoQr(),
                identificadorEntity.getCodigoBarra()
        );
    }
}
