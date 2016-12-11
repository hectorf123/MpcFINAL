/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.mpc.frontend.componentes.beans;

import co.mpc.backend.model.persistence.entities.SistemaVehiculo;
import co.mpc.backend.model.persistence.facades.SistemaVehiculoFacadeLocal;
import co.mpc.frontend.logica.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andres
 */
@Named(value="sistemaVehiculoManagedBean")
@RequestScoped
public class SistemaVehiculoManagedBean implements Serializable, IManagedBean<SistemaVehiculo>{
    
    private SistemaVehiculo sistemaVehiculo;
    @Inject SistemaVehiculoFacadeLocal sistemaVehiculoFacadeLocal;
    /** Creates a new instance of SistemaVehiculoManagedBean */
    public SistemaVehiculoManagedBean() {
    }
    @PostConstruct
    public void init(){
        sistemaVehiculo = new SistemaVehiculo();
    }
    @Override
    public SistemaVehiculo getObjectByKey(Integer key) {
        return sistemaVehiculoFacadeLocal.find(key);
    }

    public SistemaVehiculo getSistemaVehiculo() {
        return sistemaVehiculo;
    }

    public void setSistemaVehiculo(SistemaVehiculo sistemaVehiculo) {
        this.sistemaVehiculo = sistemaVehiculo;
    }
    
    public List<SistemaVehiculo> listar(){
        return sistemaVehiculoFacadeLocal.findAll();
    }
    
    public void registrar(){
        sistemaVehiculoFacadeLocal.create(sistemaVehiculo);
    }
}