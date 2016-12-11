/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.facades;

import co.mpc.backend.model.persistence.entities.EstadoComponente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juank
 */
@Local
public interface EstadoComponenteFacadeLocal {

    void create(EstadoComponente estadoComponente);

    void edit(EstadoComponente estadoComponente);

    void remove(EstadoComponente estadoComponente);

    EstadoComponente find(Object id);

    List<EstadoComponente> findAll();

    List<EstadoComponente> findRange(int[] range);

    int count();
    
}
