/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.facades;

import co.mpc.backend.model.persistence.entities.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Juank
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "ProyectoMpcWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario atenticarUsuario(Usuario u) {
        Usuario usuario = null;
        TypedQuery<Usuario> query;
        try {
            query = em.createQuery("FROM Usuario u WHERE u.numeroCedula = ?1 and u.clave = ?2", Usuario.class);
            query.setParameter(1, u.getNumeroCedula());
            query.setParameter(2, u.getClave());
            if (!query.getResultList().isEmpty()) {
                usuario = query.getResultList().get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return usuario;
    }

    @Override
    public Usuario verificarUsuario(Usuario u) {
        TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByCorreoElectronico", Usuario.class);
        TypedQuery<Usuario> queryCedula = em.createNamedQuery("Usuario.findByNumeroCedula", Usuario.class);
        query.setParameter("correoElectronico", u.getCorreoElectronico());
        queryCedula.setParameter("numeroCedula", u.getNumeroCedula());
        if (!query.getResultList().isEmpty() || !queryCedula.getResultList().isEmpty()) {
            return query.getResultList().get(0);
        } else {
            return null;
        }
    }
}
