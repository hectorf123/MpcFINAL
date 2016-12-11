/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "conductores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conductor.findAll", query = "SELECT c FROM Conductor c")
    , @NamedQuery(name = "Conductor.findByIdUsuarioConductor", query = "SELECT c FROM Conductor c WHERE c.idUsuarioConductor = :idUsuarioConductor")
    , @NamedQuery(name = "Conductor.findByNumeroLicencia", query = "SELECT c FROM Conductor c WHERE c.numeroLicencia = :numeroLicencia")
    , @NamedQuery(name = "Conductor.findByFechaVenicimientoLicencia", query = "SELECT c FROM Conductor c WHERE c.fechaVenicimientoLicencia = :fechaVenicimientoLicencia")})
public class Conductor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario_conductor")
    private Integer idUsuarioConductor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 33)
    @Column(name = "numero_licencia")
    private String numeroLicencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venicimiento_licencia")
    @Temporal(TemporalType.DATE)
    private Date fechaVenicimientoLicencia;
    @JoinTable(name = "conductores_vehiculos", joinColumns = {
        @JoinColumn(name = "id_conductor", referencedColumnName = "id_usuario_conductor")}, inverseJoinColumns = {
        @JoinColumn(name = "id_vehiculo_conductor", referencedColumnName = "id_vehiculo")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Vehiculo> vehiculoCollection;
    @JoinColumn(name = "id_categoria_licencia", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoriaLicencia idCategoriaLicencia;
    @JoinColumn(name = "id_usuario_conductor", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idConductorFalla", fetch = FetchType.LAZY)
    private Collection<FallaVehiculo> fallaVehiculoCollection;

    public Conductor() {
    }

    public Conductor(Integer idUsuarioConductor) {
        this.idUsuarioConductor = idUsuarioConductor;
    }

    public Conductor(Integer idUsuarioConductor, String numeroLicencia, Date fechaVenicimientoLicencia) {
        this.idUsuarioConductor = idUsuarioConductor;
        this.numeroLicencia = numeroLicencia;
        this.fechaVenicimientoLicencia = fechaVenicimientoLicencia;
    }

    public Integer getIdUsuarioConductor() {
        return idUsuarioConductor;
    }

    public void setIdUsuarioConductor(Integer idUsuarioConductor) {
        this.idUsuarioConductor = idUsuarioConductor;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public Date getFechaVenicimientoLicencia() {
        return fechaVenicimientoLicencia;
    }

    public void setFechaVenicimientoLicencia(Date fechaVenicimientoLicencia) {
        this.fechaVenicimientoLicencia = fechaVenicimientoLicencia;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(Collection<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
    }

    public CategoriaLicencia getIdCategoriaLicencia() {
        return idCategoriaLicencia;
    }

    public void setIdCategoriaLicencia(CategoriaLicencia idCategoriaLicencia) {
        this.idCategoriaLicencia = idCategoriaLicencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @XmlTransient
    public Collection<FallaVehiculo> getFallaVehiculoCollection() {
        return fallaVehiculoCollection;
    }

    public void setFallaVehiculoCollection(Collection<FallaVehiculo> fallaVehiculoCollection) {
        this.fallaVehiculoCollection = fallaVehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioConductor != null ? idUsuarioConductor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conductor)) {
            return false;
        }
        Conductor other = (Conductor) object;
        if ((this.idUsuarioConductor == null && other.idUsuarioConductor != null) || (this.idUsuarioConductor != null && !this.idUsuarioConductor.equals(other.idUsuarioConductor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.model.persistence.entities.Conductor[ idUsuarioConductor=" + idUsuarioConductor + " ]";
    }
    
}
