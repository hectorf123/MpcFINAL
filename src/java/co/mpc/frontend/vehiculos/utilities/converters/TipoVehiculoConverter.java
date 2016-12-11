package co.mpc.frontend.vehiculos.utilities.converters;

import co.mpc.backend.model.persistence.entities.TipoVehiculo;
import co.mpc.frontend.logica.AbstractConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = TipoVehiculo.class)
public class TipoVehiculoConverter extends AbstractConverter{

    public TipoVehiculoConverter(){
        this.namedManagedBean = "tipoVehiculoManagedBean";
    }
}
