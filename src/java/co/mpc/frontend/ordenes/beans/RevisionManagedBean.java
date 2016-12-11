/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.beans;

import co.mpc.backend.model.persistence.entities.Revision;
import co.mpc.backend.model.persistence.facades.RevisionFacadeLocal;
import co.mpc.frontend.logica.IManagedBean;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Juank
 */
@Named(value = "revisionManagedBean")
@RequestScoped
public class RevisionManagedBean implements Serializable, IManagedBean<Revision> {

    private Revision revision;
    @Inject
    private RevisionFacadeLocal revisionFL;

    public RevisionManagedBean() {
    }

    @PostConstruct
    public void init() {
        revision = new Revision();
    }

    @Override
    public Revision getObjectByKey(Integer key) {
        return revisionFL.find(key);
    }

    public Revision getRevision() {
        return revision;
    }

    public void setRevision(Revision revision) {
        this.revision = revision;
    }

    public void registrarRevision() {
        revisionFL.create(revision);
    }

    public void eliminarRevision() {
        revisionFL.remove(revision);
    }

    public List<Revision> listarRevision() {
        return revisionFL.findAll();
    }

}
