/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.facades;

import co.mpc.backend.model.persistence.entities.EstadoVehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juank
 */
@Local
public interface EstadoVehiculoFacadeLocal {

    void create(EstadoVehiculo estadoVehiculo);

    void edit(EstadoVehiculo estadoVehiculo);

    void remove(EstadoVehiculo estadoVehiculo);

    EstadoVehiculo find(Object id);

    List<EstadoVehiculo> findAll();

    List<EstadoVehiculo> findRange(int[] range);

    int count();
    
}
