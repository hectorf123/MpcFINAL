/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.vehiculos.beans;

import co.mpc.backend.model.persistence.entities.Vehiculo;
import co.mpc.backend.model.persistence.facades.VehiculoFacadeLocal;
import javax.inject.Named;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import co.mpc.frontend.logica.IManagedBean;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Andres
 */
@Named(value = "vehiculoManagedBean")
@RequestScoped
public class VehiculoManagedBean implements Serializable, IManagedBean<Vehiculo> {

    private Vehiculo vehiculo;
    @Inject
    private VehiculoFacadeLocal vFL;

    public VehiculoManagedBean() {
    }

    @PostConstruct
    public void init() {
        vehiculo = new Vehiculo();
    }

    @Override
    public Vehiculo getObjectByKey(Integer key) {
        return vFL.find(key);
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    //CRUD
    public List<Vehiculo> listar() {
        return vFL.findAll();
    }

    public void registrar() {
        try {
            vFL.create(vehiculo);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("No se puede registrar un vehículo con el mismo número de matricula."));
        }

    }

    public void eliminar(Vehiculo v) {
        vFL.remove(v);
    }
}
