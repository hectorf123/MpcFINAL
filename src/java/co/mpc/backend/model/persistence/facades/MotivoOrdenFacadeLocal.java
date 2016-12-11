/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.facades;

import co.mpc.backend.model.persistence.entities.MotivoOrden;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juank
 */
@Local
public interface MotivoOrdenFacadeLocal {

    void create(MotivoOrden motivoOrden);

    void edit(MotivoOrden motivoOrden);

    void remove(MotivoOrden motivoOrden);

    MotivoOrden find(Object id);

    List<MotivoOrden> findAll();

    List<MotivoOrden> findRange(int[] range);

    int count();
    
}
