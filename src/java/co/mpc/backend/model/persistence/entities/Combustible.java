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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jason St
 */
@Entity
@Table(name = "combustible")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Combustible.findAll", query = "SELECT c FROM Combustible c")
    , @NamedQuery(name = "Combustible.findByIdTipoCombustible", query = "SELECT c FROM Combustible c WHERE c.idTipoCombustible = :idTipoCombustible")
    , @NamedQuery(name = "Combustible.findByNombreTipoCombustible", query = "SELECT c FROM Combustible c WHERE c.nombreTipoCombustible = :nombreTipoCombustible")})
public class Combustible implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_combustible")
    private Boolean idTipoCombustible;
    @Size(max = 40)
    @Column(name = "nombre_tipo_combustible")
    private String nombreTipoCombustible;

    public Combustible() {
    }

    public Combustible(Boolean idTipoCombustible) {
        this.idTipoCombustible = idTipoCombustible;
    }

    public Boolean getIdTipoCombustible() {
        return idTipoCombustible;
    }

    public void setIdTipoCombustible(Boolean idTipoCombustible) {
        this.idTipoCombustible = idTipoCombustible;
    }

    public String getNombreTipoCombustible() {
        return nombreTipoCombustible;
    }

    public void setNombreTipoCombustible(String nombreTipoCombustible) {
        this.nombreTipoCombustible = nombreTipoCombustible;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCombustible != null ? idTipoCombustible.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Combustible)) {
            return false;
        }
        Combustible other = (Combustible) object;
        if ((this.idTipoCombustible == null && other.idTipoCombustible != null) || (this.idTipoCombustible != null && !this.idTipoCombustible.equals(other.idTipoCombustible))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.model.persistence.entities.Combustible[ idTipoCombustible=" + idTipoCombustible + " ]";
    }
    
}
