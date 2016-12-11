package co.mpc.frontend.componentes.utilities.converters;

import co.mpc.backend.model.persistence.entities.SistemaVehiculo;
import co.mpc.frontend.logica.AbstractConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = SistemaVehiculo.class)
public class SistemaVehiculoConverter extends AbstractConverter{

    public SistemaVehiculoConverter(){
        this.namedManagedBean = "sistemaVehiculoManagedBean";
    }
}
