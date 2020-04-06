package eg.bazinga.sfgpetclinic.repositories;

import eg.bazinga.sfgpetclinic.models.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository extends CrudRepository<Vet, Long> {
}
