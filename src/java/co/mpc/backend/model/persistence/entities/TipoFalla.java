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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "tipos_fallas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoFalla.findAll", query = "SELECT t FROM TipoFalla t")
    , @NamedQuery(name = "TipoFalla.findByIdTipoFalla", query = "SELECT t FROM TipoFalla t WHERE t.idTipoFalla = :idTipoFalla")
    , @NamedQuery(name = "TipoFalla.findByNombreTipoFalla", query = "SELECT t FROM TipoFalla t WHERE t.nombreTipoFalla = :nombreTipoFalla")})
public class TipoFalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_falla")
    private Integer idTipoFalla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 33)
    @Column(name = "nombre_tipo_falla")
    private String nombreTipoFalla;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion_text")
    private String descripcionText;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoFalla", fetch = FetchType.LAZY)
    private Collection<FallaVehiculo> fallaVehiculoCollection;

    public TipoFalla() {
    }

    public TipoFalla(Integer idTipoFalla) {
        this.idTipoFalla = idTipoFalla;
    }

    public TipoFalla(Integer idTipoFalla, String nombreTipoFalla, String descripcionText) {
        this.idTipoFalla = idTipoFalla;
        this.nombreTipoFalla = nombreTipoFalla;
        this.descripcionText = descripcionText;
    }

    public Integer getIdTipoFalla() {
        return idTipoFalla;
    }

    public void setIdTipoFalla(Integer idTipoFalla) {
        this.idTipoFalla = idTipoFalla;
    }

    public String getNombreTipoFalla() {
        return nombreTipoFalla;
    }

    public void setNombreTipoFalla(String nombreTipoFalla) {
        this.nombreTipoFalla = nombreTipoFalla;
    }

    public String getDescripcionText() {
        return descripcionText;
    }

    public void setDescripcionText(String descripcionText) {
        this.descripcionText = descripcionText;
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
        hash += (idTipoFalla != null ? idTipoFalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoFalla)) {
            return false;
        }
        TipoFalla other = (TipoFalla) object;
        if ((this.idTipoFalla == null && other.idTipoFalla != null) || (this.idTipoFalla != null && !this.idTipoFalla.equals(other.idTipoFalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.model.persistence.entities.TipoFalla[ idTipoFalla=" + idTipoFalla + " ]";
    }
    
}
