package ar.net.edufmass.springpetclinic.repositories;

import ar.net.edufmass.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
