/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.facades;

import co.mpc.backend.model.persistence.entities.Combustible;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jason St
 */
@Stateless
public class CombustibleFacade extends AbstractFacade<Combustible> implements CombustibleFacadeLocal {

    @PersistenceContext(unitName = "ProyectoMpcWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CombustibleFacade() {
        super(Combustible.class);
    }
    
}
