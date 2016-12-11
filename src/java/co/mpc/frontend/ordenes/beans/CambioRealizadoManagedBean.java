/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.beans;

import co.mpc.backend.model.persistence.entities.CambioRealizado;
import co.mpc.backend.model.persistence.facades.CambioRealizadoFacadeLocal;
import co.mpc.frontend.logica.IManagedBean;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Juank
 */
@Named(value = "cambioRealizadoManagedBean")
@RequestScoped
public class CambioRealizadoManagedBean implements Serializable,IManagedBean<CambioRealizado> {

    private CambioRealizado cambioRealizado;
    @Inject
    private CambioRealizadoFacadeLocal cambioRealizadoFL;

    public CambioRealizadoManagedBean() {
    }

    @PostConstruct
    public void init() {
        cambioRealizado = new CambioRealizado();
    }

    @Override
    public CambioRealizado getObjectByKey(Integer key) {
        return cambioRealizadoFL.find(key);
    }

    public CambioRealizado getCambioRealizado() {
        return cambioRealizado;
    }

    public void setCambioRealizado(CambioRealizado cambioRealizado) {
        this.cambioRealizado = cambioRealizado;
    }
    
    public void registrarCambioRealizado(){
        cambioRealizadoFL.create(cambioRealizado);
    }
    
    public void eliminarCambioRealizado(){
        cambioRealizadoFL.remove(cambioRealizado);
    }
       
    public List<CambioRealizado> listarCambioRealizado(){
        return cambioRealizadoFL.findAll();
    }
}
