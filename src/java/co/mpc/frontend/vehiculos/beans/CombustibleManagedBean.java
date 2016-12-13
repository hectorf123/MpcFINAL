package co.mpc.frontend.vehiculos.beans;

import co.mpc.backend.model.persistence.entities.Combustible;
import co.mpc.backend.model.persistence.facades.CombustibleFacadeLocal;
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

@Named(value = "combustibleManagedBean")
@RequestScoped
public class CombustibleManagedBean implements Serializable, IManagedBean<Combustible> {


    private Combustible combustible;
    
    @EJB private CombustibleFacadeLocal combustibleFacadeLocal;
    
    public CombustibleManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        combustible = new Combustible();
    }
    
       
    @Override
    public Combustible getObjectByKey(Integer id) {
        return combustibleFacadeLocal.find(id);
    }
    
    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }
    
   
    
   // Metodos
    public void registrarCombustible(){       
        combustibleFacadeLocal.create(combustible);
    }
    
    public void eliminarCombustible(Combustible c){
        combustibleFacadeLocal.remove(c);
    }
    
    public List<Combustible> listaCombustible(){
        return combustibleFacadeLocal.findAll();
    }
    
    public void editarCombustible(Combustible c){
        combustibleFacadeLocal.edit(c);
    }



    
}
