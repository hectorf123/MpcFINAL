package co.mpc.frontend.usuarios.utilities.coverters;

import co.mpc.frontend.logica.AbstractConverter;
import co.mpc.backend.model.persistence.entities.Ciudad;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Ciudad.class )
public class CiudadConverter extends AbstractConverter{

    public CiudadConverter(){
        this.namedManagedBean = "ciudadManagedBean";
    }
}

