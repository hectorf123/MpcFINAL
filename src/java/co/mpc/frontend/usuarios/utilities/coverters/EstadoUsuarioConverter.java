package co.mpc.frontend.usuarios.utilities.coverters;

import co.mpc.backend.model.persistence.entities.EstadoUsuario;
import co.mpc.frontend.logica.AbstractConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = EstadoUsuario.class)
public class EstadoUsuarioConverter extends AbstractConverter{

    public EstadoUsuarioConverter(){
        this.namedManagedBean = "estadoUsuarioManagedBean";
    }
}