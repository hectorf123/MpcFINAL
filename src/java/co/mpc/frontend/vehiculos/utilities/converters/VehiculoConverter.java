package co.mpc.frontend.vehiculos.utilities.converters;

import co.mpc.backend.model.persistence.entities.Vehiculo;
import co.mpc.frontend.logica.AbstractConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Vehiculo.class)
public class VehiculoConverter extends AbstractConverter{

    public VehiculoConverter(){
        this.namedManagedBean = "vehiculoManagedBean";
    }
}
