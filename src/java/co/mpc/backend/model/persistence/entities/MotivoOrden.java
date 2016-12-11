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
@Table(name = "motivos_ordenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotivoOrden.findAll", query = "SELECT m FROM MotivoOrden m")
    , @NamedQuery(name = "MotivoOrden.findByIdMotivo", query = "SELECT m FROM MotivoOrden m WHERE m.idMotivo = :idMotivo")
    , @NamedQuery(name = "MotivoOrden.findByMotivo", query = "SELECT m FROM MotivoOrden m WHERE m.motivo = :motivo")})
public class MotivoOrden implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_motivo")
    private Integer idMotivo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 33)
    @Column(name = "motivo")
    private String motivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMotivo", fetch = FetchType.LAZY)
    private Collection<Orden> ordenCollection;

    public MotivoOrden() {
    }

    public MotivoOrden(Integer idMotivo) {
        this.idMotivo = idMotivo;
    }

    public MotivoOrden(Integer idMotivo, String motivo) {
        this.idMotivo = idMotivo;
        this.motivo = motivo;
    }

    public Integer getIdMotivo() {
        return idMotivo;
    }

    public void setIdMotivo(Integer idMotivo) {
        this.idMotivo = idMotivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @XmlTransient
    public Collection<Orden> getOrdenCollection() {
        return ordenCollection;
    }

    public void setOrdenCollection(Collection<Orden> ordenCollection) {
        this.ordenCollection = ordenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMotivo != null ? idMotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotivoOrden)) {
            return false;
        }
        MotivoOrden other = (MotivoOrden) object;
        if ((this.idMotivo == null && other.idMotivo != null) || (this.idMotivo != null && !this.idMotivo.equals(other.idMotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.model.persistence.entities.MotivoOrden[ idMotivo=" + idMotivo + " ]";
    }

    @Override
    public String getPK() {
        return idMotivo.toString();
    }
    
}
