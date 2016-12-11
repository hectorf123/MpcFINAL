/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "estados_vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoVehiculo.findAll", query = "SELECT e FROM EstadoVehiculo e")
    , @NamedQuery(name = "EstadoVehiculo.findByIdEstadoVehiculo", query = "SELECT e FROM EstadoVehiculo e WHERE e.idEstadoVehiculo = :idEstadoVehiculo")
    , @NamedQuery(name = "EstadoVehiculo.findByNombreEstadoVehiuclo", query = "SELECT e FROM EstadoVehiculo e WHERE e.nombreEstadoVehiuclo = :nombreEstadoVehiuclo")})
public class EstadoVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estado_vehiculo")
    private Integer idEstadoVehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_estado_vehiuclo")
    private String nombreEstadoVehiuclo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoVehiculo", fetch = FetchType.LAZY)
    private Collection<Vehiculo> vehiculoCollection;

    public EstadoVehiculo() {
    }

    public EstadoVehiculo(Integer idEstadoVehiculo) {
        this.idEstadoVehiculo = idEstadoVehiculo;
    }

    public EstadoVehiculo(Integer idEstadoVehiculo, String nombreEstadoVehiuclo) {
        this.idEstadoVehiculo = idEstadoVehiculo;
        this.nombreEstadoVehiuclo = nombreEstadoVehiuclo;
    }

    public Integer getIdEstadoVehiculo() {
        return idEstadoVehiculo;
    }

    public void setIdEstadoVehiculo(Integer idEstadoVehiculo) {
        this.idEstadoVehiculo = idEstadoVehiculo;
    }

    public String getNombreEstadoVehiuclo() {
        return nombreEstadoVehiuclo;
    }

    public void setNombreEstadoVehiuclo(String nombreEstadoVehiuclo) {
        this.nombreEstadoVehiuclo = nombreEstadoVehiuclo;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(Collection<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoVehiculo != null ? idEstadoVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoVehiculo)) {
            return false;
        }
        EstadoVehiculo other = (EstadoVehiculo) object;
        if ((this.idEstadoVehiculo == null && other.idEstadoVehiculo != null) || (this.idEstadoVehiculo != null && !this.idEstadoVehiculo.equals(other.idEstadoVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.model.persistence.entities.EstadoVehiculo[ idEstadoVehiculo=" + idEstadoVehiculo + " ]";
    }
    
}
