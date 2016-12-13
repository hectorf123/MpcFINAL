/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.mpc.backend.bussiness.security;

import co.mpc.backend.model.persistence.entities.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Andres
 */
@Named(value="sessionBeanProteccion")
@ViewScoped
public class SessionBeanProteccion implements Serializable{

    public void verificarSesion() throws IOException{
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            if(us == null){
                ExternalContext em = FacesContext.getCurrentInstance().getExternalContext();
                em.redirect(em.getRequestContextPath() + "/index.xhtml");
            }
    }
}