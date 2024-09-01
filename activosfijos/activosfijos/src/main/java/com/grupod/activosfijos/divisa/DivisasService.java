package com.grupod.activosfijos.divisa;

import com.grupod.activosfijos.utils.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DivisasService {
    private final DivisasRepository divisasRepository;

    @Autowired
    public DivisasService(DivisasRepository divisasRepository) {
        this.divisasRepository = divisasRepository;
    }

    public ResponseEntity<ResponseDto<DivisasDto>> crearDivisa(DivisasDto divisasDto) {
        DivisasEntity divisaEntity = new DivisasEntity();
        divisaEntity.setNombre(divisasDto.getNombre());
        divisaEntity.setValor(divisasDto.getValor());
        divisaEntity.setFecha(new Date());

        DivisasEntity nuevaDivisa = divisasRepository.save(divisaEntity);

        DivisasDto nuevaDivisaDto = new DivisasDto(
                nuevaDivisa.getIdDivisa(),
                nuevaDivisa.getNombre(),
                nuevaDivisa.getValor(),
                nuevaDivisa.getFecha(),
                null
        );

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto<>(true, "Divisa creada exitosamente", nuevaDivisaDto));
    }

    public ResponseEntity<ResponseDto<List<DivisasDto>>> obtenerTodasLasDivisas() {
        List<DivisasEntity> divisas = divisasRepository.findAll();
        List<DivisasDto> divisasDto = divisas.stream()
                .map(divisa -> new DivisasDto(
                        divisa.getIdDivisa(),
                        divisa.getNombre(),
                        divisa.getValor(),
                        divisa.getFecha(),
                        null))
                .collect(Collectors.toList());

        ResponseDto<List<DivisasDto>> responseDto = new ResponseDto<>(true, "Divisas obtenidas exitosamente", divisasDto);
        return ResponseEntity.ok(responseDto);
    }

    public ResponseEntity<ResponseDto<DivisasDto>> obtenerDivisaPorId(Integer id) {
        Optional<DivisasEntity> divisaOpt = divisasRepository.findById(id);
        if (divisaOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDto<>(false, "Divisa no encontrada", null));
        }

        DivisasEntity divisaEntity = divisaOpt.get();
        DivisasDto divisaDto = new DivisasDto(
                divisaEntity.getIdDivisa(),
                divisaEntity.getNombre(),
                divisaEntity.getValor(),
                divisaEntity.getFecha(),
                null
        );
        return ResponseEntity.ok(new ResponseDto<>(true, "Divisa obtenida exitosamente", divisaDto));
    }

    public ResponseEntity<ResponseDto<DivisasDto>> actualizarDivisa(Integer id, DivisasDto divisasDto) {
        Optional<DivisasEntity> divisaOpt = divisasRepository.findById(id);
        if (divisaOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDto<>(false, "Divisa no encontrada", null));
        }

        DivisasEntity divisaEntity = divisaOpt.get();
        divisaEntity.setNombre(divisasDto.getNombre());
        divisaEntity.setValor(divisasDto.getValor());
        divisaEntity.setFecha(divisasDto.getFecha());
        divisaEntity = divisasRepository.save(divisaEntity);

        DivisasDto actualizadaDivisaDto = new DivisasDto(
                divisaEntity.getIdDivisa(),
                divisaEntity.getNombre(),
                divisaEntity.getValor(),
                divisaEntity.getFecha(),
                null
        );
        return ResponseEntity.ok(new ResponseDto<>(true, "Divisa actualizada exitosamente", actualizadaDivisaDto));
    }

    public ResponseEntity<ResponseDto<Void>> eliminarDivisa(Integer id) {
        if (!divisasRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDto<>(false, "Divisa no encontrada", null));
        }

        divisasRepository.deleteById(id);
        return ResponseEntity.ok(new ResponseDto<>(true, "Divisa eliminada exitosamente", null));
    }
}
