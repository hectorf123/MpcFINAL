package co.mpc.frontend.usuarios.beans;

import co.mpc.backend.model.persistence.entities.Conductor;
import co.mpc.backend.model.persistence.facades.ConductorFacadeLocal;
import co.mpc.frontend.logica.IManagedBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author Miguel Angel Rivera Niño
 */

@Named(value = "conductorManagedBean")
@RequestScoped
public class ConductorManagedBean implements Serializable, IManagedBean<Conductor>{

    private Conductor conductor;
    @EJB private ConductorFacadeLocal conductorFacadeLocal;
    
    public ConductorManagedBean() {
    }
    @PostConstruct
    public void init(){
        conductor = new Conductor();
    }
    @Override
    public Conductor getObjectByKey(Integer key) {
        return conductorFacadeLocal.find(key);
    }
    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }
     public void registrarConductor(){
        conductorFacadeLocal.create(conductor);
    }
    public void eliminarConductor(Conductor c){
        conductorFacadeLocal.remove(conductor);
    }
    public List<Conductor> listarConductor(){
        return conductorFacadeLocal.findAll();
    }
    public void editarConductor(Conductor e){
        conductorFacadeLocal.edit(conductor);
    }
}

