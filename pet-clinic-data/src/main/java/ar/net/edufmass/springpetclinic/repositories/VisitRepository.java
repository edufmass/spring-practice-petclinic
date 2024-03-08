package ar.net.edufmass.springpetclinic.repositories;

import ar.net.edufmass.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
