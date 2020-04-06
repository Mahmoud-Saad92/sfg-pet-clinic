package eg.bazinga.sfgpetclinic.repositories;

import eg.bazinga.sfgpetclinic.models.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
