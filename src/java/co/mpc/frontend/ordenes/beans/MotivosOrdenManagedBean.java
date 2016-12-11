/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.beans;

import co.mpc.backend.model.persistence.entities.MotivoOrden;
import co.mpc.backend.model.persistence.facades.MotivoOrdenFacadeLocal;
import co.mpc.frontend.logica.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Juank
 */
@Named(value = "motivosOrdenManagedBean")
@RequestScoped
public class MotivosOrdenManagedBean implements Serializable, IManagedBean<MotivoOrden> {

    private MotivoOrden motivoOrden;
    @EJB
    private MotivoOrdenFacadeLocal motivoOrdenFL;

    public MotivosOrdenManagedBean() {
    }

    @PostConstruct
    public void init() {
        motivoOrden = new MotivoOrden();
    }

    @Override
    public MotivoOrden getObjectByKey(Integer key) {
        return motivoOrdenFL.find(key);
    }

    public MotivoOrden getMotivoOrden() {
        return motivoOrden;
    }

    public void setMotivoOrden(MotivoOrden motivoOrden) {
        this.motivoOrden = motivoOrden;
    }
    
    public void registrarOrden(){
        motivoOrdenFL.create(motivoOrden);
    }
    
    public void eliminarOrden(){
        motivoOrdenFL.remove(motivoOrden);
    }
    
    public List<MotivoOrden> listarMotivoOrden(){
        return motivoOrdenFL.findAll();
    }

}
