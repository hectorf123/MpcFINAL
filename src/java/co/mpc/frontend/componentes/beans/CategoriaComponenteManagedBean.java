/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.componentes.beans;

import co.mpc.backend.model.persistence.entities.CategoriaComponente;
import co.mpc.backend.model.persistence.facades.CategoriaComponenteFacadeLocal;
import co.mpc.frontend.logica.IManagedBean;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Juank
 */
@Named(value = "categoriaComponenteManagedBean")
@RequestScoped
public class CategoriaComponenteManagedBean implements Serializable, IManagedBean<CategoriaComponente> {

    private CategoriaComponente categoriaComponente;
    @EJB
    private CategoriaComponenteFacadeLocal categoriaComponenteFacadeLocal; 
    public CategoriaComponenteManagedBean() {
    }

    @Override
    public CategoriaComponente getObjectByKey(Integer key) {
        return categoriaComponenteFacadeLocal.find(key);
    }
    
    
    
}
