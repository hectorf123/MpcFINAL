/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.facades;

import co.mpc.backend.model.persistence.entities.CategoriaComponente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Juank
 */
@Stateless
public class CategoriaComponenteFacade extends AbstractFacade<CategoriaComponente> implements CategoriaComponenteFacadeLocal {

    @PersistenceContext(unitName = "ProyectoMpcWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaComponenteFacade() {
        super(CategoriaComponente.class);
    }
    
}
