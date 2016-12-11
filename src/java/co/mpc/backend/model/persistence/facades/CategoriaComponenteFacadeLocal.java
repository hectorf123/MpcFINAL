/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.backend.model.persistence.facades;

import co.mpc.backend.model.persistence.entities.CategoriaComponente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Juank
 */
@Local
public interface CategoriaComponenteFacadeLocal {

    void create(CategoriaComponente categoriaComponente);

    void edit(CategoriaComponente categoriaComponente);

    void remove(CategoriaComponente categoriaComponente);

    CategoriaComponente find(Object id);

    List<CategoriaComponente> findAll();

    List<CategoriaComponente> findRange(int[] range);

    int count();
    
}
