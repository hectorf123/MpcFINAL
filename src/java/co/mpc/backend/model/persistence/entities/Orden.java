/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "ordenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orden.findAll", query = "SELECT o FROM Orden o")
    , @NamedQuery(name = "Orden.findByIdOrden", query = "SELECT o FROM Orden o WHERE o.idOrden = :idOrden")
    , @NamedQuery(name = "Orden.findByFechaEmision", query = "SELECT o FROM Orden o WHERE o.fechaEmision = :fechaEmision")
    , @NamedQuery(name = "Orden.findByIdVehiculo", query = "SELECT o FROM Orden o WHERE o.idVehiculo=:idVehiculo")
    , @NamedQuery(name = "Orden.findByPlazoMaximo", query = "SELECT o FROM Orden o WHERE o.plazoMaximo = :plazoMaximo")})
public class Orden implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_orden")
    private Integer idOrden;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plazo_maximo")
    @Temporal(TemporalType.DATE)
    private Date plazoMaximo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orden", fetch = FetchType.LAZY)
    private Mantenimiento mantenimiento;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orden", fetch = FetchType.LAZY)
    private Revision revision;
    @JoinColumn(name = "id_estado_orden", referencedColumnName = "id_estado_orden")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoOrden idEstadoOrden;
    @JoinColumn(name = "id_motivo", referencedColumnName = "id_motivo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MotivoOrden idMotivo;
    @JoinColumn(name = "id_tipo_orden", referencedColumnName = "id_tipo_orden")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoOrden idTipoOrden;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "id_vehiculo", referencedColumnName = "id_vehiculo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vehiculo idVehiculo;

    public Orden() {
    }

    public Orden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Orden(Integer idOrden, Date fechaEmision, Date plazoMaximo) {
        this.idOrden = idOrden;
        this.fechaEmision = fechaEmision;
        this.plazoMaximo = plazoMaximo;
    }

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getPlazoMaximo() {
        return plazoMaximo;
    }

    public void setPlazoMaximo(Date plazoMaximo) {
        this.plazoMaximo = plazoMaximo;
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public Revision getRevision() {
        return revision;
    }

    public void setRevision(Revision revision) {
        this.revision = revision;
    }

    public EstadoOrden getIdEstadoOrden() {
        return idEstadoOrden;
    }

    public void setIdEstadoOrden(EstadoOrden idEstadoOrden) {
        this.idEstadoOrden = idEstadoOrden;
    }

    public MotivoOrden getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(MotivoOrden idMotivo) {
        this.idMotivo = idMotivo;
    }

    public TipoOrden getIdTipoOrden() {
        return idTipoOrden;
    }

    public void setIdTipoOrden(TipoOrden idTipoOrden) {
        this.idTipoOrden = idTipoOrden;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Vehiculo getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Vehiculo idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrden != null ? idOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orden)) {
            return false;
        }
        Orden other = (Orden) object;
        if ((this.idOrden == null && other.idOrden != null) || (this.idOrden != null && !this.idOrden.equals(other.idOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.model.persistence.entities.Orden[ idOrden=" + idOrden + " ]";
    }

    @Override
    public String getPK() {
        return idOrden.toString();
    }

}
