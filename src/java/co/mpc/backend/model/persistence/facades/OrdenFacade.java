/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.facades;

import co.mpc.backend.model.persistence.entities.Orden;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Juank
 */
@Stateless
public class OrdenFacade extends AbstractFacade<Orden> implements OrdenFacadeLocal {

    @PersistenceContext(unitName = "ProyectoMpcWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdenFacade() {
        super(Orden.class);
    }

    @Override
    public Orden verificarOrden(Orden o) {
        TypedQuery<Orden> tO = em.createNamedQuery("Orden.findByIdVehiculo", Orden.class);
        tO.setParameter("idVehiculo", o.getIdVehiculo());
        if (tO.getResultList().size() > 4) {
            return tO.getResultList().get(0);
        } else {
            return null;
        }
    }
}
