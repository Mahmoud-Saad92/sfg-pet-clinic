package eg.bazinga.sfgpetclinic.repositories;

import eg.bazinga.sfgpetclinic.models.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
