/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.beans;

import co.mpc.backend.model.persistence.entities.TipoOrden;
import co.mpc.backend.model.persistence.facades.TipoOrdenFacadeLocal;
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
@Named(value = "tipoOrdenManagedBean")
@RequestScoped
public class TipoOrdenManagedBean implements Serializable, IManagedBean<TipoOrden> {

    private TipoOrden tipoOrden;
    @Inject
    private TipoOrdenFacadeLocal tipoOrdenFL;

    public TipoOrdenManagedBean() {
    }

    @PostConstruct
    public void init() {
        tipoOrden = new TipoOrden();
    }

    @Override
    public TipoOrden getObjectByKey(Integer key) {
        return tipoOrdenFL.find(key);
    }

    public TipoOrden getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(TipoOrden tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    public void registrarTipoOrden() {
        tipoOrdenFL.create(tipoOrden);
    }

    public void eliminarTipoOrden() {
        tipoOrdenFL.remove(tipoOrden);
    }

    public List<TipoOrden> listarTipoOrden() {
        return tipoOrdenFL.findAll();
    }

}
