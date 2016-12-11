package co.mpc.frontend.usuarios.utilities.coverters;

import co.mpc.frontend.logica.AbstractConverter;
import co.mpc.backend.model.persistence.entities.Conductor;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Conductor.class )
public class ConductorConverter extends AbstractConverter{

    public ConductorConverter(){
        this.namedManagedBean = "conductorManagedBean";
    }
}
