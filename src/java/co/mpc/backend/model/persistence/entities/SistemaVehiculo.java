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
@Table(name = "sistemas_vehiculos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SistemaVehiculo.findAll", query = "SELECT s FROM SistemaVehiculo s")
    , @NamedQuery(name = "SistemaVehiculo.findByIdCategoriaComponente", query = "SELECT s FROM SistemaVehiculo s WHERE s.idCategoriaComponente = :idCategoriaComponente")
    , @NamedQuery(name = "SistemaVehiculo.findByNombreCategoriaComponente", query = "SELECT s FROM SistemaVehiculo s WHERE s.nombreCategoriaComponente = :nombreCategoriaComponente")})
public class SistemaVehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_categoria_componente")
    private Integer idCategoriaComponente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombre_categoria_componente")
    private String nombreCategoriaComponente;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaComponenteComponente", fetch = FetchType.LAZY)
    private Collection<Componente> componenteCollection;

    public SistemaVehiculo() {
    }

    public SistemaVehiculo(Integer idCategoriaComponente) {
        this.idCategoriaComponente = idCategoriaComponente;
    }

    public SistemaVehiculo(Integer idCategoriaComponente, String nombreCategoriaComponente) {
        this.idCategoriaComponente = idCategoriaComponente;
        this.nombreCategoriaComponente = nombreCategoriaComponente;
    }

    public Integer getIdCategoriaComponente() {
        return idCategoriaComponente;
    }

    public void setIdCategoriaComponente(Integer idCategoriaComponente) {
        this.idCategoriaComponente = idCategoriaComponente;
    }

    public String getNombreCategoriaComponente() {
        return nombreCategoriaComponente;
    }

    public void setNombreCategoriaComponente(String nombreCategoriaComponente) {
        this.nombreCategoriaComponente = nombreCategoriaComponente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Componente> getComponenteCollection() {
        return componenteCollection;
    }

    public void setComponenteCollection(Collection<Componente> componenteCollection) {
        this.componenteCollection = componenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaComponente != null ? idCategoriaComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SistemaVehiculo)) {
            return false;
        }
        SistemaVehiculo other = (SistemaVehiculo) object;
        if ((this.idCategoriaComponente == null && other.idCategoriaComponente != null) || (this.idCategoriaComponente != null && !this.idCategoriaComponente.equals(other.idCategoriaComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.model.persistence.entities.SistemaVehiculo[ idCategoriaComponente=" + idCategoriaComponente + " ]";
    }
    
}
