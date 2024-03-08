package ar.net.edufmass.springpetclinic.repositories;

import ar.net.edufmass.springpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
