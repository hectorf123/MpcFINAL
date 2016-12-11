/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.mpc.frontend.ordenes.utilities.converters;

import co.mpc.backend.model.persistence.entities.Revision;
import co.mpc.frontend.logica.AbstractConverter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Juank
 */
@FacesConverter(forClass = Revision.class)
public class RevisionConverter extends AbstractConverter{

    public RevisionConverter() {
        this.namedManagedBean="revisionManagedBean";
    }
    
}
