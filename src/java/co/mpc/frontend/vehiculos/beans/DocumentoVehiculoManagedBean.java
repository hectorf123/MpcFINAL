package co.mpc.frontend.vehiculos.beans;

import co.mpc.backend.model.persistence.entities.DocumentoVehiculo;
import co.mpc.backend.model.persistence.entities.EstadoDocumento;
import co.mpc.backend.model.persistence.entities.TipoDocumento;
import co.mpc.backend.model.persistence.entities.Vehiculo;
import co.mpc.backend.model.persistence.facades.DocumentoVehiculoFacadeLocal;
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

@Named(value = "documentoVehiculosManagedBean")
@RequestScoped
public class DocumentoVehiculoManagedBean implements Serializable, IManagedBean<DocumentoVehiculo> {


    private DocumentoVehiculo documentoVehiculo;
    private Vehiculo vehiculo;
    private TipoDocumento tipoDocumento;
    private EstadoDocumento estadoDocumento;

    
    @EJB private DocumentoVehiculoFacadeLocal documentoVehiculoFacadeLocal;
    
    public DocumentoVehiculoManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        documentoVehiculo = new DocumentoVehiculo();
    }
    

    
    @Override
    public DocumentoVehiculo getObjectByKey(Integer id) {
        return documentoVehiculoFacadeLocal.find(id);
    }

    
    public DocumentoVehiculo getDocumentoVehiculo() {
        return documentoVehiculo;
    }

    public void setDocumentoVehiculo(DocumentoVehiculo documentoVehiculo) {
        this.documentoVehiculo = documentoVehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public EstadoDocumento getEstadoDocumento() {
        return estadoDocumento;
    }

    public void setEstadoDocumento(EstadoDocumento estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }
   
    
   // Metodos
    public void registrarDocumentoVehiculo(){       
        documentoVehiculoFacadeLocal.create(documentoVehiculo);
    }
    
    public void eliminarDocumentoVehiculo(DocumentoVehiculo dv){
        documentoVehiculoFacadeLocal.remove(dv);
    }
    
    public List<DocumentoVehiculo> listaDocumentoVehiculos(){
        return documentoVehiculoFacadeLocal.findAll();
    }
    
    public void editarDocumentoVehiculo(DocumentoVehiculo dv){
        documentoVehiculoFacadeLocal.edit(dv);
    }

    
}
