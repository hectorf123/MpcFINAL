/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.bussiness.security;

import co.mpc.backend.model.persistence.entities.Usuario;
import javax.ejb.Local;

/**
 *
 * @author Andres
 */
@Local
public interface SessionBeanLoginLocal {
    void invalidarSession();
}
