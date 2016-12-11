/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.beans;

import co.mpc.backend.model.persistence.entities.EstadoOrden;
import co.mpc.backend.model.persistence.facades.EstadoOrdenFacadeLocal;
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
@Named(value = "estadoOrdenManagedBean")
@RequestScoped
public class EstadoOrdenManagedBean implements Serializable, IManagedBean<EstadoOrden> {

    private EstadoOrden estadoOrden;
    @Inject
    private EstadoOrdenFacadeLocal estadoOrdenFL;

    public EstadoOrdenManagedBean() {
    }

    @PostConstruct
    public void init() {
        estadoOrden = new EstadoOrden();
    }

    @Override
    public EstadoOrden getObjectByKey(Integer key) {
        return estadoOrdenFL.find(key);
    }

    public EstadoOrden getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(EstadoOrden estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public void registrarEstadoOrden() {
        estadoOrdenFL.create(estadoOrden);
    }

    public void eliminarEstadoOrden() {
        estadoOrdenFL.remove(estadoOrden);
    }

    public List<EstadoOrden> listarEstadoOrden() {
        return estadoOrdenFL.findAll();
    }

}
