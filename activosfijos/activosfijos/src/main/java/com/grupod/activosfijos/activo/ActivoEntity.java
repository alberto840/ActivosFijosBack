package com.grupod.activosfijos.activo;

import com.grupod.activosfijos.aula.AulaEntity;
import com.grupod.activosfijos.bloque.BloqueEntity;
import com.grupod.activosfijos.categoria.CategoriaEntity;
import com.grupod.activosfijos.custodio.CustodioEntity;
import com.grupod.activosfijos.depreciacion.DepreciacionEntity;
import com.grupod.activosfijos.estadoActivo.EstadoactivoEntity;
import com.grupod.activosfijos.historialActivos.HistorialActivosEntity;
import com.grupod.activosfijos.identificador.IdentificadorEntity;
import com.grupod.activosfijos.proyecto.ProyectoEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "activo")
public class ActivoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_activo")
    private Integer idActivo;

    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;

    @Basic(optional = false)
    @Column(name = "valor_actual")
    private BigDecimal valorActual;

    @Basic(optional = false)
    @Column(name = "valor_inicial")
    private BigDecimal valorInicial;

    @Basic(optional = false)
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Basic(optional = false)
    @Column(name = "detalle")
    private String detalle;

    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;

    @Basic(optional = false)
    @Column(name = "precio")
    private BigDecimal precio;

    @Basic(optional = false)
    @Column(name = "comprobante_compra")
    private String comprobanteCompra;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activoEntity")
    private List<HistorialActivosEntity> historialActivosEntityList;

    @ManyToOne
    @JoinColumn(name = "aula_id", referencedColumnName = "id_aula")
    private AulaEntity aulaEntity;

    @JoinColumn(name = "bloque_id", referencedColumnName = "id_bloque")
    @ManyToOne(optional = false)
    private BloqueEntity bloqueEntity;  // Asegúrate de que este es el nombre correcto que usa el mappedBy

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id_categoria")
    private CategoriaEntity categoriaEntity;


    @ManyToOne
    @JoinColumn(name = "custodio_id", referencedColumnName = "id_custodio")
    private CustodioEntity custodioEntity;

    @JoinColumn(name = "depreciacion_id", referencedColumnName = "id_depreciacion")
    @ManyToOne(optional = false)
    private DepreciacionEntity depreciacionEntity;

    @ManyToOne
    @JoinColumn(name = "estadoactivo_id", referencedColumnName = "id_estado")
    private EstadoactivoEntity estadoactivoEntity;

    @ManyToOne
    @JoinColumn(name = "identificador_id", referencedColumnName = "id_identificador")
    private IdentificadorEntity identificadorEntity;

    @ManyToOne
    @JoinColumn(name = "proyecto_id", referencedColumnName = "id_proyecto")
    private ProyectoEntity proyectoEntity;

    public ActivoEntity() {
    }

    public ActivoEntity(Integer idActivo, String nombre, BigDecimal valorActual, BigDecimal valorInicial, Date fechaRegistro, String detalle, boolean estado, BigDecimal precio, String comprobanteCompra) {
        this.idActivo = idActivo;
        this.nombre = nombre;
        this.valorActual = valorActual;
        this.valorInicial = valorInicial;
        this.fechaRegistro = fechaRegistro;
        this.detalle = detalle;
        this.estado = estado;
        this.precio = precio;
        this.comprobanteCompra = comprobanteCompra;
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

    public boolean isEstado() {
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

    public List<HistorialActivosEntity> getHistorialActivosEntityList() {
        return historialActivosEntityList;
    }

    public void setHistorialActivosEntityList(List<HistorialActivosEntity> historialActivosEntityList) {
        this.historialActivosEntityList = historialActivosEntityList;
    }

    public AulaEntity getAulaEntity() {
        return aulaEntity;
    }

    public void setAulaEntity(AulaEntity aulaEntity) {
        this.aulaEntity = aulaEntity;
    }

    public BloqueEntity getBloqueEntity() {
        return bloqueEntity;
    }

    public void setBloqueEntity(BloqueEntity bloqueEntity) {
        this.bloqueEntity = bloqueEntity;
    }

    public CategoriaEntity getCategoriaEntity() {
        return categoriaEntity;
    }

    public void setCategoriaEntity(CategoriaEntity categoriaEntity) {
        this.categoriaEntity = categoriaEntity;
    }

    public CustodioEntity getCustodioEntity() {
        return custodioEntity;
    }

    public void setCustodioEntity(CustodioEntity custodioEntity) {
        this.custodioEntity = custodioEntity;
    }

    public DepreciacionEntity getDepreciacionEntity() {
        return depreciacionEntity;
    }

    public void setDepreciacionEntity(DepreciacionEntity depreciacionEntity) {
        this.depreciacionEntity = depreciacionEntity;
    }

    public EstadoactivoEntity getEstadoactivoEntity() {
        return estadoactivoEntity;
    }

    public void setEstadoactivoEntity(EstadoactivoEntity estadoactivoEntity) {
        this.estadoactivoEntity = estadoactivoEntity;
    }

    public IdentificadorEntity getIdentificadorEntity() {
        return identificadorEntity;
    }

    public void setIdentificadorEntity(IdentificadorEntity identificadorEntity) {
        this.identificadorEntity = identificadorEntity;
    }

    public ProyectoEntity getProyectoEntity() {
        return proyectoEntity;
    }

    public void setProyectoEntity(ProyectoEntity proyectoEntity) {
        this.proyectoEntity = proyectoEntity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActivo != null ? idActivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ActivoEntity)) {
            return false;
        }
        ActivoEntity other = (ActivoEntity) object;
        if ((this.idActivo == null && other.idActivo != null) || (this.idActivo != null && !this.idActivo.equals(other.idActivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.grupod.activosfijos.activo.ActivoEntity[ idActivo=" + idActivo + " ]";
    }
}
