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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juank
 */
@Entity
@Table(name = "categorias_componentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaComponente.findAll", query = "SELECT c FROM CategoriaComponente c")
    , @NamedQuery(name = "CategoriaComponente.findByIdCategoriaComponente", query = "SELECT c FROM CategoriaComponente c WHERE c.idCategoriaComponente = :idCategoriaComponente")
    , @NamedQuery(name = "CategoriaComponente.findByNombreCategoriaComponente", query = "SELECT c FROM CategoriaComponente c WHERE c.nombreCategoriaComponente = :nombreCategoriaComponente")})
public class CategoriaComponente implements Serializable, IEntity {

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

    public CategoriaComponente() {
    }

    public CategoriaComponente(Integer idCategoriaComponente) {
        this.idCategoriaComponente = idCategoriaComponente;
    }

    public CategoriaComponente(Integer idCategoriaComponente, String nombreCategoriaComponente) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategoriaComponente != null ? idCategoriaComponente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaComponente)) {
            return false;
        }
        CategoriaComponente other = (CategoriaComponente) object;
        if ((this.idCategoriaComponente == null && other.idCategoriaComponente != null) || (this.idCategoriaComponente != null && !this.idCategoriaComponente.equals(other.idCategoriaComponente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.mpc.backend.model.persistence.entities.CategoriaComponente[ idCategoriaComponente=" + idCategoriaComponente + " ]";
    }

    @Override
    public String getPK() {
        return idCategoriaComponente.toString();
    }
    
}
