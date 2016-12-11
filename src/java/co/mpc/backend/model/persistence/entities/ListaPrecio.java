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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "listas_precios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaPrecio.findAll", query = "SELECT l FROM ListaPrecio l")
    , @NamedQuery(name = "ListaPrecio.findByIdListaPrecio", query = "SELECT l FROM ListaPrecio l WHERE l.idListaPrecio = :idListaPrecio")
    , @NamedQuery(name = "ListaPrecio.findByPrecio", query = "SELECT l FROM ListaPrecio l WHERE l.precio = :precio")})
public class ListaPrecio implements Serializable, IEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lista_precio")
    private Integer idListaPrecio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Double precio;
    @JoinColumn(name = "id_componente", referencedColumnName = "id_componente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Componente idComponente;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_provedor")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Proveedor idProveedor;

    public ListaPrecio() {
    }

    public ListaPrecio(Integer idListaPrecio) {
        this.idListaPrecio = idListaPrecio;
    }

    public Integer getIdListaPrecio() {
        return idListaPrecio;
    }

    public void setIdListaPrecio(Integer idListaPrecio) {
        this.idListaPrecio = idListaPrecio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Componente getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Componente idComponente) {
        this.idComponente = idComponente;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idListaPrecio != null ? idListaPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaPrecio)) {
            return false;
        }
        ListaPrecio other = (ListaPrecio) object;
        if ((this.idListaPrecio == null && other.idListaPrecio != null) || (this.idListaPrecio != null && !this.idListaPrecio.equals(other.idListaPrecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.model.persistence.entities.ListaPrecio[ idListaPrecio=" + idListaPrecio + " ]";
    }

    @Override
    public String getPK() {
        return idListaPrecio.toString();
    
    }
    
}
