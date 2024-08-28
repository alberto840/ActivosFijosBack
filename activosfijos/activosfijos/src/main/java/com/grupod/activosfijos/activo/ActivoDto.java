package com.grupod.activosfijos.activo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.grupod.activosfijos.aula.AulaDto;
import com.grupod.activosfijos.bloque.BloqueDto;
import com.grupod.activosfijos.categoria.CategoriaDto;
import com.grupod.activosfijos.custodio.CustodioDto;
import com.grupod.activosfijos.depreciacion.DepreciacionDto;
import com.grupod.activosfijos.estadoActivo.EstadoactivoDto;
import com.grupod.activosfijos.historialActivos.HistorialActivosDto;
import com.grupod.activosfijos.identificador.IdentificadorDto;
import com.grupod.activosfijos.proyecto.ProyectoDto;

public class ActivoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idActivo;
    private String nombre;
    private BigDecimal valorActual;
    private BigDecimal valorInicial;
    private Date fechaRegistro;
    private String detalle;
    private boolean estado;
    private BigDecimal precio;
    private String comprobanteCompra;
    private List<HistorialActivosDto> historialActivos;
    private AulaDto aula;
    private BloqueDto bloque;
    private CategoriaDto categoria;
    private CustodioDto custodio;
    private DepreciacionDto depreciacion;
    private EstadoactivoDto estadoactivo;
    private IdentificadorDto identificador;
    private ProyectoDto proyecto;

    public ActivoDto() {
    }

    public ActivoDto(Integer idActivo, String nombre, BigDecimal valorActual, BigDecimal valorInicial, Date fechaRegistro, String detalle, boolean estado, BigDecimal precio, String comprobanteCompra, AulaDto aula, BloqueDto bloque, CategoriaDto categoria, CustodioDto custodio, DepreciacionDto depreciacion, EstadoactivoDto estadoactivo, IdentificadorDto identificador, ProyectoDto proyecto, List<HistorialActivosDto> historialActivos) {
        this.idActivo = idActivo;
        this.nombre = nombre;
        this.valorActual = valorActual;
        this.valorInicial = valorInicial;
        this.fechaRegistro = fechaRegistro;
        this.detalle = detalle;
        this.estado = estado;
        this.precio = precio;
        this.comprobanteCompra = comprobanteCompra;
        this.aula = aula;
        this.bloque = bloque;
        this.categoria = categoria;
        this.custodio = custodio;
        this.depreciacion = depreciacion;
        this.estadoactivo = estadoactivo;
        this.identificador = identificador;
        this.proyecto = proyecto;
        this.historialActivos = historialActivos;
    }

    public Integer getIdActivo() {
        return idActivo;
    }

    public void setIdActivo(Integer idActivo) {
        this.idActivo = idActivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getValorActual() {
        return valorActual;
    }

    public void setValorActual(BigDecimal valorActual) {
        this.valorActual = valorActual;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getComprobanteCompra() {
        return comprobanteCompra;
    }

    public void setComprobanteCompra(String comprobanteCompra) {
        this.comprobanteCompra = comprobanteCompra;
    }

    public List<HistorialActivosDto> getHistorialActivos() {
        return historialActivos;
    }

    public void setHistorialActivos(List<HistorialActivosDto> historialActivos) {
        this.historialActivos = historialActivos;
    }

    public AulaDto getAula() {
        return aula;
    }

    public void setAula(AulaDto aula) {
        this.aula = aula;
    }

    public BloqueDto getBloque() {
        return bloque;
    }

    public void setBloque(BloqueDto bloque) {
        this.bloque = bloque;
    }

    public CategoriaDto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDto categoria) {
        this.categoria = categoria;
    }

    public CustodioDto getCustodio() {
        return custodio;
    }

    public void setCustodio(CustodioDto custodio) {
        this.custodio = custodio;
    }

    public DepreciacionDto getDepreciacion() {
        return depreciacion;
    }

    public void setDepreciacion(DepreciacionDto depreciacion) {
        this.depreciacion = depreciacion;
    }

    public EstadoactivoDto getEstadoactivo() {
        return estadoactivo;
    }

    public void setEstadoactivo(EstadoactivoDto estadoactivo) {
        this.estadoactivo = estadoactivo;
    }

    public IdentificadorDto getIdentificador() {
        return identificador;
    }

    public void setIdentificador(IdentificadorDto identificador) {
        this.identificador = identificador;
    }

    public ProyectoDto getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoDto proyecto) {
        this.proyecto = proyecto;
    }

    @Override
    public String toString() {
        return "ActivoDto{" +
                "idActivo=" + idActivo +
                ", nombre='" + nombre + '\'' +
                ", valorActual=" + valorActual +
                ", valorInicial=" + valorInicial +
                ", fechaRegistro=" + fechaRegistro +
                ", detalle='" + detalle + '\'' +
                ", estado=" + estado +
                ", precio=" + precio +
                ", comprobanteCompra='" + comprobanteCompra + '\'' +
                ", historialActivos=" + historialActivos +
                ", aula=" + aula +
                ", bloque=" + bloque +
                ", categoria=" + categoria +
                ", custodio=" + custodio +
                ", depreciacion=" + depreciacion +
                ", estadoactivo=" + estadoactivo +
                ", identificador=" + identificador +
                ", proyecto=" + proyecto +
                '}';
    }
}
