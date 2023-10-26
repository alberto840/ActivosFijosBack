package com.grupod.activosfijos.activo;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table
public class ActivoEntity {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_activo;
    private String activo_nombre;
    private Integer marca_id_marca;
    private BigDecimal  activo_valor;
    private String activo_categoria;
    private String activo_custodio;
    private String activo_direccion;
    private String activo_comprobante;
    private Integer pais_id_pais;
    private Integer departamento_id_departamento;
    private Integer municipio_id_municipio;
    private Integer area_id_area;
    private Integer bloque_id_bloque;
    private Integer aula_id_aula;
    private Integer detalle_id_detalle;
    
}
