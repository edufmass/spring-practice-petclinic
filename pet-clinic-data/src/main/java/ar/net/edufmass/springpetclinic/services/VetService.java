package ar.net.edufmass.springpetclinic.services;

import ar.net.edufmass.springpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Set<Vet> findAll();

    Vet findById(Long id);

    Vet save(Vet object);
}
