package com.grupod.activosfijos.custodio;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustodioService {
    
    private final CustodioRepository custodioRepository;

    @Autowired
    public CustodioService(CustodioRepository custodioRepository) {
        this.custodioRepository = custodioRepository;
    }

    public List<CustodioEntity>getCustodio(){
        return this.custodioRepository.findAll();
    }
    public ResponseEntity<Object> addNewCustodio(CustodioEntity custodio){
        Optional<CustodioEntity> res = custodioRepository.findCustodioBycustodioId(custodio.getId_custodio());
        HashMap<String, Object> datos = new HashMap<>();

        if(res.isPresent()){
            datos.put("error", true);
            datos.put("message", "Ya existe custodio con este id");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        custodioRepository.save(custodio);
        datos.put("datos", custodio);
        datos.put("message", "Se registró con exito el custodio");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    }
}
