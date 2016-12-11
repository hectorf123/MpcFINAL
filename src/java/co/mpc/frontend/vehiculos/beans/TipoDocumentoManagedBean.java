package co.mpc.frontend.vehiculos.beans;

import co.mpc.backend.model.persistence.entities.TipoDocumento;
import co.mpc.backend.model.persistence.facades.TipoDocumentoFacadeLocal;
import co.mpc.frontend.logica.IManagedBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Brayan Mendez
 */
@Named(value = "tipoDocumentoManagedBean")
@RequestScoped
public class TipoDocumentoManagedBean implements Serializable, IManagedBean {
    
    private TipoDocumento tipoDocumento;
    
    @EJB TipoDocumentoFacadeLocal tipoDocumentoFacadeLocal;

    public TipoDocumentoManagedBean() {
    }
    
    @PostConstruct
    
    public void init(){
        tipoDocumento = new TipoDocumento();
    }

    @Override
    public Object getObjectByKey(Integer id) {
        return tipoDocumentoFacadeLocal.find(id);
    }
 
    

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    
    // Metodos
    
    public void registrarTipoDocumento(){
        tipoDocumentoFacadeLocal.create(tipoDocumento);
    }
    
    public void elimianrTipoDocumento(TipoDocumento td){
        tipoDocumentoFacadeLocal.remove(td);
    }
    
    public List<TipoDocumento> listaTipoDocumento(){
        return tipoDocumentoFacadeLocal.findAll();
    }
    
    public void editarTipoDocumento(TipoDocumento td){
        tipoDocumentoFacadeLocal.edit(td);
    }


    
    
}
