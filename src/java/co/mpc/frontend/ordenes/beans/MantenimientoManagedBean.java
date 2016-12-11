/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.beans;

import co.mpc.backend.model.persistence.entities.Mantenimiento;
import co.mpc.backend.model.persistence.facades.MantenimientoFacadeLocal;
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
@Named(value = "mantenimientoManagedBean")
@RequestScoped
public class MantenimientoManagedBean implements Serializable, IManagedBean<Mantenimiento> {

    /**
     * Creates a new instance of MantenimientoManagedBean
     */
    private Mantenimiento mantenimiento;
    @Inject
    private MantenimientoFacadeLocal mantenimientoFL;

    public MantenimientoManagedBean() {
    }

    @PostConstruct
    public void init() {
        mantenimiento = new Mantenimiento();
    }

    @Override
    public Mantenimiento getObjectByKey(Integer key) {
        return mantenimientoFL.find(key);
    }

    public Mantenimiento getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(Mantenimiento mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public void registrarMantenimiento() {
        mantenimientoFL.create(mantenimiento);
    }

    public void eliminarMantenimiento() {
        mantenimientoFL.remove(mantenimiento);
    }

    public List<Mantenimiento> listarMantenimientos() {
        return mantenimientoFL.findAll();
    }

}
