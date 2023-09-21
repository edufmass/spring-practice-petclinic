package ar.net.edufmass.springpetclinic.services;

import ar.net.edufmass.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
