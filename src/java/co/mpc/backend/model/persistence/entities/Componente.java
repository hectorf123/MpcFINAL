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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "componentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Componente.findAll", query = "SELECT c FROM Componente c")
    , @NamedQuery(name = "Componente.findByIdComponente", query = "SELECT c FROM Componente c WHERE c.idComponente = :idComponente")
    , @NamedQuery(name = "Componente.findByNombreComponente", query = "SELECT c FROM Componente c WHERE c.nombreComponente = :nombreComponente")
    , @NamedQuery(name = "Componente.findByVidaUtil", query = "SELECT c FROM Componente c WHERE c.vidaUtil = :vidaUtil")})
public class Componente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_componente")
    private Integer idComponente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_componente")
    private String nombreComponente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vida_util")
    private int vidaUtil;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComponente", fetch = FetchType.LAZY)
    private Collection<ComponenteVehiculo> componenteVehiculoCollection;
    @JoinColumn(name = "id_categoria_componente_componente", referencedColumnName = "id_categoria_componente")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SistemaVehiculo idCategoriaComponenteComponente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComponente", fetch = FetchType.LAZY)
    private Collection<ListaPrecio> listaPrecioCollection;

    public Componente() {
    }

    public Componente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public Componente(Integer idComponente, String nombreComponente, int vidaUtil) {
        this.idComponente = idComponente;
        this.nombreComponente = nombreComponente;
        this.vidaUtil = vidaUtil;
    }

    public Integer getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Integer idComponente) {
        this.idComponente = idComponente;
    }

    public String getNombreComponente() {
        return nombreComponente;
    }

    public void setNombreComponente(String nombreComponente) {
        this.nombreComponente = nombreComponente;
    }

    public int getVidaUtil() {
        return vidaUtil;
    }

    public void setVidaUtil(int vidaUtil) {
        this.vidaUtil = vidaUtil;
    }

    @XmlTransient
    public Collection<ComponenteVehiculo> getComponenteVehiculoCollection() {
        return componenteVehiculoCollection;
    }

    public void setComponenteVehiculoCollection(Collection<ComponenteVehiculo> componenteVehiculoCollection) {
        this.componenteVehiculoCollection = componenteVehiculoCollection;
    }

    public SistemaVehiculo getIdCategoriaComponenteComponente() {
        return idCategoriaComponenteComponente;
    }

    public void setIdCategoriaComponenteComponente(SistemaVehiculo idCategoriaComponenteComponente) {
        this.idCategoriaComponenteComponente = idCategoriaComponenteComponente;
    }

    @XmlTransient
    public Collection<ListaPrecio> getListaPrecioCollection() {
        return listaPrecioCollection;
    }

    public void setListaPrecioCollection(Collection<ListaPrecio> listaPrecioCollection) {
        this.listaPrecioCollection = listaPrecioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComponente != null ? idComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Componente)) {
            return false;
        }
        Componente other = (Componente) object;
        if ((this.idComponente == null && other.idComponente != null) || (this.idComponente != null && !this.idComponente.equals(other.idComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.model.persistence.entities.Componente[ idComponente=" + idComponente + " ]";
    }
    
}
