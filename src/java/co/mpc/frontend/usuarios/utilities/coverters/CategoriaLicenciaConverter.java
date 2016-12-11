package co.mpc.frontend.usuarios.utilities.coverters;

import co.mpc.backend.model.persistence.entities.CategoriaLicencia;
import co.mpc.frontend.logica.AbstractConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = CategoriaLicencia.class)
public class CategoriaLicenciaConverter extends AbstractConverter{

    public CategoriaLicenciaConverter(){
        this.namedManagedBean = "categoriaLicenciaManagedBean";
    }
}
