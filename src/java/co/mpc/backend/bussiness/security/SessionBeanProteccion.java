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

    public void verificarSesion(){
        FacesContext context = FacesContext.getCurrentInstance();
        try{
            Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
            if(us == null){
                context.getExternalContext().redirect("./../../permisos.xhtml");
                context.addMessage(null, new FacesMessage("Permisos insuficientes."));
            }
        }catch (IOException e) {
            context.addMessage(null, new FacesMessage("Ocurrio un error permisos"));
        }
    }
}