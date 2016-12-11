/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.mpc.frontend.usuarios.beans;

import co.mpc.backend.model.persistence.entities.Rol;
import co.mpc.backend.model.persistence.facades.RolFacadeLocal;
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
@Named(value="rolManagedBean")
@RequestScoped
public class RolManagedBean implements Serializable,IManagedBean<Rol>{

    private Rol rol;
    @Inject private RolFacadeLocal rFL;

    public RolManagedBean() {
    }
    @PostConstruct
    public void init(){
        rol = new Rol();
    }

    @Override
    public Rol getObjectByKey(Integer key){
        return  rFL.find(key);
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    

    //CRUD
    public List<Rol> listar(){
        return rFL.findAll();
    }
    
    public void registrar(){
        rFL.create(rol);
    }
    
    public void eliminar(Rol r){
        rFL.remove(r);
    }
}