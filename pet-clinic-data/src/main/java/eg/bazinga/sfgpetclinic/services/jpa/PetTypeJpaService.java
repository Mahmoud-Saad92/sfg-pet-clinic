package eg.bazinga.sfgpetclinic.services.jpa;

import eg.bazinga.sfgpetclinic.models.PetType;
import eg.bazinga.sfgpetclinic.repositories.PetTypeRepository;
import eg.bazinga.sfgpetclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class PetTypeJpaService implements PetTypeService {

    private PetTypeRepository petTypeRepository;

    @Autowired
    public PetTypeJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findById(Long id) {
        return petTypeRepository.findById(id).orElse(null);
    }

    @Override
    public PetType save(PetType petType) {
        return petTypeRepository.save(petType);
    }

    @Override
    public Set<PetType> findAll() {
        HashSet<PetType> types = new HashSet<>();
        petTypeRepository.findAll().iterator().forEachRemaining(types::add);

        return types;
    }

    @Override
    public void delete(PetType petType) {
        petTypeRepository.delete(petType);
    }

    @Override
    public void deleteById(Long id) {
        petTypeRepository.deleteById(id);
    }
}
