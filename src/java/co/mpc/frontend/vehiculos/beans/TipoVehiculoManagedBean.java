/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.mpc.frontend.vehiculos.beans;

import co.mpc.backend.model.persistence.entities.TipoVehiculo;
import co.mpc.backend.model.persistence.facades.TipoVehiculoFacadeLocal;
import javax.inject.Named;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import co.mpc.frontend.logica.IManagedBean;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;

/**
 *
 * @author Andres
 */
@Named(value="tipoVehiculoManagedBean")
@RequestScoped
public class TipoVehiculoManagedBean implements Serializable,IManagedBean<TipoVehiculo>{

    private TipoVehiculo tipoVehiculo;
    @Inject private TipoVehiculoFacadeLocal tvfl;

    public TipoVehiculoManagedBean() {
    }
    @PostConstruct
    public void init(){
        tipoVehiculo = new TipoVehiculo();
    }

    @Override
    public TipoVehiculo getObjectByKey(Integer key){
        return tvfl.find(key);
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    
    //CRUD
    public List<TipoVehiculo> listar(){
        return tvfl.findAll();
    }
    
    public void registrar(){
        tvfl.create(tipoVehiculo);
    }
    
    public void eliminar(TipoVehiculo tv){
        tvfl.remove(tv);
    }
}
