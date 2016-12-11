package co.mpc.frontend.componentes.utilities.converters;

import co.mpc.backend.model.persistence.entities.Componente;
import co.mpc.frontend.logica.AbstractConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Componente.class)
public class ComponenteConverter extends AbstractConverter{

    public ComponenteConverter(){
        this.namedManagedBean = "componenteManagedBean";
    }
}
