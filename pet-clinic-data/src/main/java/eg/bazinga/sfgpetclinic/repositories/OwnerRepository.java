package eg.bazinga.sfgpetclinic.repositories;

import eg.bazinga.sfgpetclinic.models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
