package ar.net.edufmass.springpetclinic.services;

import ar.net.edufmass.springpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Set<Pet> findAll();

    Pet findById(Long id);

    Pet save(Pet object);
}
