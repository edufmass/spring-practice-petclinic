package ar.net.edufmass.springpetclinic.services;

import ar.net.edufmass.springpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Set<Owner> findAll();

    Owner findById(Long id);

    Owner save(Owner object);
}
