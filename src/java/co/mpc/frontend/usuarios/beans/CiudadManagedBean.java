/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.usuarios.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import co.mpc.backend.model.persistence.entities.Ciudad;
import co.mpc.backend.model.persistence.facades.CiudadFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import co.mpc.frontend.logica.IManagedBean;
import java.util.List;
@Named(value = "ciudadManagedBean")
@SessionScoped
public class CiudadManagedBean implements Serializable,IManagedBean<Ciudad>{
    private Ciudad ciudad;
    @EJB CiudadFacadeLocal ciudadFacadeLocal;
    public CiudadManagedBean() {
    }
    @PostConstruct 
    public void init(){
        ciudad = new Ciudad();
    }

    @Override
    public Ciudad getObjectByKey(Integer key) {
        return ciudadFacadeLocal.find(key);
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    public void eliminarCiudad(Ciudad c){
        ciudadFacadeLocal.remove(c);
    }
    public void registrarCiudad(){
        registrarCiudad();
    }
    public List<Ciudad> listarCiudad(){
        return ciudadFacadeLocal.findAll();
    }
    public void editarCiudad (Ciudad c){
        ciudadFacadeLocal.edit(c);
    }
}
