/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.bussiness.security;

import co.mpc.backend.model.persistence.entities.Usuario;
import co.mpc.backend.model.persistence.facades.UsuarioFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
/**
 *
 * @author Andres
 */
@Named
@SessionScoped
public class SessionBeanLogin implements Serializable{

    private Usuario usuario;
    @EJB private UsuarioFacadeLocal ufl;
    
    @PostConstruct
    public void init(){
        usuario = ufl.atenticarUsuario((Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"));
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void cerrarSession() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("../faces/index.xhtml?faces-redirect=true");
    }
    
}