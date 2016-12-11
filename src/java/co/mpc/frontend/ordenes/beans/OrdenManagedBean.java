/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.beans;

import co.mpc.backend.model.persistence.entities.Orden;
import co.mpc.backend.model.persistence.facades.OrdenFacadeLocal;
import co.mpc.frontend.logica.IManagedBean;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 *
 * @author Juank
 */
@Named(value = "ordenManagedBean")
@RequestScoped
public class OrdenManagedBean implements Serializable, IManagedBean<Orden> {

    private Orden orden;
    @Inject
    private OrdenFacadeLocal ordenFL;

    public OrdenManagedBean() {
    }

    @PostConstruct
    public void init() {
        orden = new Orden();
    }

    @Override
    public Orden getObjectByKey(Integer key) {
        return ordenFL.find(key);
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public void registrarOrden() {
        if (ordenFL.verificarOrden(orden) == null) {
            ordenFL.create(orden);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puede crear mas de 4 ordenes"));
        }
    }

    public void eliminarOrden() {
        ordenFL.remove(orden);
    }

    public List<Orden> listarOrden() {
        return ordenFL.findAll();
    }
}
