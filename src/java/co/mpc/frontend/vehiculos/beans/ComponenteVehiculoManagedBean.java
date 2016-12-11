package co.mpc.frontend.vehiculos.beans;

import co.mpc.backend.model.persistence.entities.ComponenteVehiculo;
import co.mpc.backend.model.persistence.entities.Componente;
import co.mpc.backend.model.persistence.entities.EstadoComponente;
import co.mpc.backend.model.persistence.entities.Vehiculo;
import co.mpc.backend.model.persistence.facades.ComponenteVehiculoFacadeLocal;
import co.mpc.frontend.logica.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Brayan Mendez
 */

@Named(value = "componenteVehiculosManagedBean")
@RequestScoped
public class ComponenteVehiculoManagedBean implements Serializable, IManagedBean<ComponenteVehiculo> {


    private ComponenteVehiculo componenteVehiculo;
    private Vehiculo vehiculo;
    private EstadoComponente estadoComponente;
    private Componente componente;

    
    @EJB private ComponenteVehiculoFacadeLocal componenteVehiculoFacadeLocal;
    
    public ComponenteVehiculoManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        componenteVehiculo = new ComponenteVehiculo();
    }
    
       
    @Override
    public ComponenteVehiculo getObjectByKey(Integer id) {
        return componenteVehiculoFacadeLocal.find(id);
    }
    
    public ComponenteVehiculo getComponenteVehiculo() {
        return componenteVehiculo;
    }

    public void setComponenteVehiculo(ComponenteVehiculo componenteVehiculo) {
        this.componenteVehiculo = componenteVehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public EstadoComponente getEstadoComponente() {
        return estadoComponente;
    }

    public void setEstadoComponente(EstadoComponente estadoComponente) {
        this.estadoComponente = estadoComponente;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    
   
    
   // Metodos
    public void registrarComponenteVehiculo(){       
        componenteVehiculoFacadeLocal.create(componenteVehiculo);
    }
    
    public void eliminarComponenteVehiculo(ComponenteVehiculo cv){
        componenteVehiculoFacadeLocal.remove(cv);
    }
    
    public List<ComponenteVehiculo> listaComponenteVehiculos(){
        return componenteVehiculoFacadeLocal.findAll();
    }
    
    public void editarComponenteVehiculo(ComponenteVehiculo cv){
        componenteVehiculoFacadeLocal.edit(cv);
    }



    
}
