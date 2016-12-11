/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.mpc.frontend.usuarios.beans;

import co.mpc.backend.model.persistence.entities.EstadoUsuario;
import co.mpc.backend.model.persistence.facades.EstadoUsuarioFacadeLocal;
import javax.inject.Named;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import co.mpc.frontend.logica.IManagedBean;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;

/**
 *
 * @author Andres
 */
@Named(value="estadoUsuarioManagedBean")
@RequestScoped
public class EstadoUsuarioManagedBean implements Serializable,IManagedBean<EstadoUsuario>{

    private EstadoUsuario estadoUsuario;
    @Inject private EstadoUsuarioFacadeLocal eUFL;

    public EstadoUsuarioManagedBean() {
    }
    @PostConstruct
    public void init(){
        estadoUsuario = new EstadoUsuario();
    }

    @Override
    public EstadoUsuario getObjectByKey(Integer key){
        return eUFL.find(key);
    }

    public EstadoUsuario getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(EstadoUsuario estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    
    //CRUD
    public List<EstadoUsuario> listar(){
        return eUFL.findAll();
    }
    
    public void registrar(){
        eUFL.create(estadoUsuario);
    }
    
    public void eliminar(EstadoUsuario eU){
        eUFL.remove(eU);
    }
}