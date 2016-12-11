/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "revisiones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Revision.findAll", query = "SELECT r FROM Revision r")
    , @NamedQuery(name = "Revision.findByIdRevision", query = "SELECT r FROM Revision r WHERE r.idRevision = :idRevision")
    , @NamedQuery(name = "Revision.findByFechaEntrega", query = "SELECT r FROM Revision r WHERE r.fechaEntrega = :fechaEntrega")})
public class Revision implements Serializable,IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_revision")
    private Integer idRevision;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "anomalia")
    private String anomalia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Lob
    @Column(name = "documento_adjunto_revision")
    private byte[] documentoAdjuntoRevision;
    @JoinColumn(name = "id_revision", referencedColumnName = "id_orden", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Orden orden;

    public Revision() {
    }

    public Revision(Integer idRevision) {
        this.idRevision = idRevision;
    }

    public Revision(Integer idRevision, String anomalia, Date fechaEntrega) {
        this.idRevision = idRevision;
        this.anomalia = anomalia;
        this.fechaEntrega = fechaEntrega;
    }

    public Integer getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(Integer idRevision) {
        this.idRevision = idRevision;
    }

    public String getAnomalia() {
        return anomalia;
    }

    public void setAnomalia(String anomalia) {
        this.anomalia = anomalia;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public byte[] getDocumentoAdjuntoRevision() {
        return documentoAdjuntoRevision;
    }

    public void setDocumentoAdjuntoRevision(byte[] documentoAdjuntoRevision) {
        this.documentoAdjuntoRevision = documentoAdjuntoRevision;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRevision != null ? idRevision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Revision)) {
            return false;
        }
        Revision other = (Revision) object;
        if ((this.idRevision == null && other.idRevision != null) || (this.idRevision != null && !this.idRevision.equals(other.idRevision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.model.persistence.entities.Revision[ idRevision=" + idRevision + " ]";
    }

    @Override
    public String getPK() {
        return idRevision.toString();
    }
    
}
