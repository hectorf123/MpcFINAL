package co.mpc.frontend.usuarios.utilities.coverters;

import co.mpc.backend.model.persistence.entities.Permiso;
import co.mpc.frontend.logica.AbstractConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Permiso.class)
public class PermisoConverter extends AbstractConverter{

    public PermisoConverter(){
        this.namedManagedBean = "permisoManagedBean";
    }
}
