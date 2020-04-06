package eg.bazinga.sfgpetclinic.repositories;

import eg.bazinga.sfgpetclinic.models.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
