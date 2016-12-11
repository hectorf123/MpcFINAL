/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.mpc.frontend.usuarios.beans;

import javax.inject.Named;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import co.mpc.backend.model.persistence.entities.CategoriaLicencia;
import co.mpc.backend.model.persistence.facades.CategoriaLicenciaFacadeLocal;
import co.mpc.frontend.logica.IManagedBean;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;

/**
 *
 * @author Andres
 */
@Named(value="categoriaLicenciaManagedBean")
@RequestScoped
public class CategoriaLicenciaManagedBean implements Serializable,IManagedBean<CategoriaLicencia>{

    private CategoriaLicencia categoriaLicencia;
    @Inject private CategoriaLicenciaFacadeLocal clfl;

    public CategoriaLicenciaManagedBean() {
    }
    @PostConstruct
    public void init(){
        categoriaLicencia = new CategoriaLicencia();
    }

    @Override
    public CategoriaLicencia getObjectByKey(Integer key){
        return clfl.find(key);
    }

    public CategoriaLicencia getCategoriaLicencia() {
        return categoriaLicencia;
    }

    public void setCategoriaLicencia(CategoriaLicencia categoriaLicencia) {
        this.categoriaLicencia = categoriaLicencia;
    }

    
    //CRUD
    public List<CategoriaLicencia> listar(){
        return clfl.findAll();
    }
    
    public void registrar(){
        clfl.create(categoriaLicencia);
    }
    
    public void eliminar(CategoriaLicencia cl){
        clfl.remove(cl);
    }
}
