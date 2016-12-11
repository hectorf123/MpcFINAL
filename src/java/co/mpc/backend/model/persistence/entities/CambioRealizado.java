/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "cambios_realizados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CambioRealizado.findAll", query = "SELECT c FROM CambioRealizado c")
    , @NamedQuery(name = "CambioRealizado.findByIdCambioRealizado", query = "SELECT c FROM CambioRealizado c WHERE c.idCambioRealizado = :idCambioRealizado")
    , @NamedQuery(name = "CambioRealizado.findByPrecioComponente", query = "SELECT c FROM CambioRealizado c WHERE c.precioComponente = :precioComponente")})
public class CambioRealizado implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cambio_realizado")
    private Integer idCambioRealizado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_componente")
    private double precioComponente;
    @JoinColumn(name = "id_componente_vehiculo_cambio", referencedColumnName = "id_componente_vehiculo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ComponenteVehiculo idComponenteVehiculoCambio;
    @JoinColumn(name = "id_mantenimiento_cambio", referencedColumnName = "id_mantenimiento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mantenimiento idMantenimientoCambio;
    @JoinColumn(name = "id_proveedor_cambio", referencedColumnName = "id_provedor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proveedor idProveedorCambio;

    public CambioRealizado() {
    }

    public CambioRealizado(Integer idCambioRealizado) {
        this.idCambioRealizado = idCambioRealizado;
    }

    public CambioRealizado(Integer idCambioRealizado, double precioComponente) {
        this.idCambioRealizado = idCambioRealizado;
        this.precioComponente = precioComponente;
    }

    public Integer getIdCambioRealizado() {
        return idCambioRealizado;
    }

    public void setIdCambioRealizado(Integer idCambioRealizado) {
        this.idCambioRealizado = idCambioRealizado;
    }

    public double getPrecioComponente() {
        return precioComponente;
    }

    public void setPrecioComponente(double precioComponente) {
        this.precioComponente = precioComponente;
    }

    public ComponenteVehiculo getIdComponenteVehiculoCambio() {
        return idComponenteVehiculoCambio;
    }

    public void setIdComponenteVehiculoCambio(ComponenteVehiculo idComponenteVehiculoCambio) {
        this.idComponenteVehiculoCambio = idComponenteVehiculoCambio;
    }

    public Mantenimiento getIdMantenimientoCambio() {
        return idMantenimientoCambio;
    }

    public void setIdMantenimientoCambio(Mantenimiento idMantenimientoCambio) {
        this.idMantenimientoCambio = idMantenimientoCambio;
    }

    public Proveedor getIdProveedorCambio() {
        return idProveedorCambio;
    }

    public void setIdProveedorCambio(Proveedor idProveedorCambio) {
        this.idProveedorCambio = idProveedorCambio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCambioRealizado != null ? idCambioRealizado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CambioRealizado)) {
            return false;
        }
        CambioRealizado other = (CambioRealizado) object;
        if ((this.idCambioRealizado == null && other.idCambioRealizado != null) || (this.idCambioRealizado != null && !this.idCambioRealizado.equals(other.idCambioRealizado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.model.persistence.entities.CambioRealizado[ idCambioRealizado=" + idCambioRealizado + " ]";
    }

    @Override
    public String getPK() {
        return idCambioRealizado.toString();
    }
    
}
