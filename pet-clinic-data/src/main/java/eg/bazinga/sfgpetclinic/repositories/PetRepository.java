package eg.bazinga.sfgpetclinic.repositories;

import eg.bazinga.sfgpetclinic.models.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
