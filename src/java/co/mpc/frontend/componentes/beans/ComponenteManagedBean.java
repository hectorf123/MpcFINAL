package co.mpc.frontend.componentes.beans;

import co.mpc.backend.model.persistence.entities.Componente;
import co.mpc.backend.model.persistence.facades.ComponenteFacadeLocal;
import co.mpc.frontend.logica.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Brayan Mendez
 */

@Named(value = "componenteManagedBean")
@RequestScoped
public class ComponenteManagedBean implements Serializable, IManagedBean<Componente>{
    private Componente componente;
    @Inject private ComponenteFacadeLocal componenteFacadeLocal;
    /** Creates a new instance of ComponenteManagedBean */
    public ComponenteManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        componente = new Componente();
    }

    @Override
    public Componente getObjectByKey(Integer key) {
        return componenteFacadeLocal.find(key);
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }
    
    public void registrar(){
        componenteFacadeLocal.create(componente);
    }
    public List<Componente> listar(){
        return componenteFacadeLocal.findAll();
    }
}
