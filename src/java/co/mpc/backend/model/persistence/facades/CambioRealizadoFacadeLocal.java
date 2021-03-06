/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.facades;

import co.mpc.backend.model.persistence.entities.CambioRealizado;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juank
 */
@Local
public interface CambioRealizadoFacadeLocal {

    void create(CambioRealizado cambioRealizado);

    void edit(CambioRealizado cambioRealizado);

    void remove(CambioRealizado cambioRealizado);

    CambioRealizado find(Object id);

    List<CambioRealizado> findAll();

    List<CambioRealizado> findRange(int[] range);

    int count();
    
}
