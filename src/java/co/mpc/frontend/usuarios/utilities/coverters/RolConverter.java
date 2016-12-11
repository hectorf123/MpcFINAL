package co.mpc.frontend.usuarios.utilities.coverters;

import co.mpc.backend.model.persistence.entities.Rol;
import co.mpc.frontend.logica.AbstractConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Rol.class)
public class RolConverter extends AbstractConverter{

    public RolConverter(){
        this.namedManagedBean = "rolManagedBean";
    }
}
