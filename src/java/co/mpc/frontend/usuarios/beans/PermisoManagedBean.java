/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.mpc.frontend.usuarios.beans;

import co.mpc.backend.model.persistence.entities.Permiso;
import co.mpc.backend.model.persistence.facades.PermisoFacadeLocal;
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
@Named(value="permisoManagedBean")
@RequestScoped
public class PermisoManagedBean implements Serializable,IManagedBean<Permiso>{

    private Permiso permiso;
    @Inject private PermisoFacadeLocal pFL;
    
    public PermisoManagedBean() {
    }
    @PostConstruct
    public void init(){
        permiso = new Permiso();
    }

    @Override
    public Permiso getObjectByKey(Integer key){
        return pFL.find(key);
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    
    //CRUD
    public List<Permiso> listar(){
        return pFL.findAll();
    }
    
    public void registrar(){
        pFL.create(permiso);
    }
    
    public void eliminar(Permiso p){
        pFL.remove(p);
    }
}
