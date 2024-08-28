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
import jakarta.persistence.Entity;
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
    @Basic(optional = false)
    @Column(name = "id_activo")
    private Integer idActivo;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activoId")
    private List<HistorialActivosEntity> historialActivosEntityList;
    @JoinColumn(name = "aula_id", referencedColumnName = "id_aula")
    @ManyToOne(optional = false)
    private AulaEntity aulaEntityId;
    @JoinColumn(name = "bloque_id", referencedColumnName = "id_bloque")
    @ManyToOne(optional = false)
    private BloqueEntity bloqueEntityId;
    @JoinColumn(name = "categoria_id", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private CategoriaEntity categoriaEntityId;
    @JoinColumn(name = "custodio_id", referencedColumnName = "id_custodio")
    @ManyToOne(optional = false)
    private CustodioEntity custodioEntityId;
    @JoinColumn(name = "depreciacion_id", referencedColumnName = "id_depreciacion")
    @ManyToOne(optional = false)
    private DepreciacionEntity depreciacionEntityId;
    @JoinColumn(name = "estadoactivo_id", referencedColumnName = "id_estado")
    @ManyToOne(optional = false)
    private EstadoactivoEntity estadoactivoEntityId;
    @JoinColumn(name = "identificador_id", referencedColumnName = "id_identificador")
    @ManyToOne(optional = false)
    private IdentificadorEntity identificadorEntityId;
    @JoinColumn(name = "proyecto_id", referencedColumnName = "id_proyecto")
    @ManyToOne(optional = false)
    private ProyectoEntity proyectoEntityId;

    public ActivoEntity() {
    }

    public ActivoEntity(Integer idActivo) {
        this.idActivo = idActivo;
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

    public List<HistorialActivosEntity> getHistorialactivosList() {
        return historialActivosEntityList;
    }

    public void setHistorialactivosList(List<HistorialActivosEntity> historialActivosEntityList) {
        this.historialActivosEntityList = historialActivosEntityList;
    }

    public AulaEntity getAulaId() {
        return aulaEntityId;
    }

    public void setAulaId(AulaEntity aulaEntityId) {
        this.aulaEntityId = aulaEntityId;
    }

    public BloqueEntity getBloqueId() {
        return bloqueEntityId;
    }

    public void setBloqueId(BloqueEntity bloqueEntityId) {
        this.bloqueEntityId = bloqueEntityId;
    }

    public CategoriaEntity getCategoriaId() {
        return categoriaEntityId;
    }

    public void setCategoriaId(CategoriaEntity categoriaEntityId) {
        this.categoriaEntityId = categoriaEntityId;
    }

    public CustodioEntity getCustodioId() {
        return custodioEntityId;
    }

    public void setCustodioId(CustodioEntity custodioEntityId) {
        this.custodioEntityId = custodioEntityId;
    }

    public DepreciacionEntity getDepreciacionId() {
        return depreciacionEntityId;
    }

    public void setDepreciacionId(DepreciacionEntity depreciacionEntityId) {
        this.depreciacionEntityId = depreciacionEntityId;
    }

    public EstadoactivoEntity getEstadoactivoId() {
        return estadoactivoEntityId;
    }

    public void setEstadoactivoId(EstadoactivoEntity estadoactivoEntityId) {
        this.estadoactivoEntityId = estadoactivoEntityId;
    }

    public IdentificadorEntity getIdentificadorId() {
        return identificadorEntityId;
    }

    public void setIdentificadorId(IdentificadorEntity identificadorEntityId) {
        this.identificadorEntityId = identificadorEntityId;
    }

    public ProyectoEntity getProyectoId() {
        return proyectoEntityId;
    }

    public void setProyectoId(ProyectoEntity proyectoEntityId) {
        this.proyectoEntityId = proyectoEntityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActivo != null ? idActivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
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
        return "com.grupod.activosfijos.activo.Activo[ idActivo=" + idActivo + " ]";
    }
    
}
