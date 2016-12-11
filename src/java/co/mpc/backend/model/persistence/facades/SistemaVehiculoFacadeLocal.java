/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.facades;

import co.mpc.backend.model.persistence.entities.SistemaVehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juank
 */
@Local
public interface SistemaVehiculoFacadeLocal {

    void create(SistemaVehiculo sistemaVehiculo);

    void edit(SistemaVehiculo sistemaVehiculo);

    void remove(SistemaVehiculo sistemaVehiculo);

    SistemaVehiculo find(Object id);

    List<SistemaVehiculo> findAll();

    List<SistemaVehiculo> findRange(int[] range);

    int count();
    
}
