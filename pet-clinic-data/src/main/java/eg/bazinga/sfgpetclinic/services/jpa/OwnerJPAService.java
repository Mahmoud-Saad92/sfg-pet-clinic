package eg.bazinga.sfgpetclinic.services.jpa;

import eg.bazinga.sfgpetclinic.models.Owner;
import eg.bazinga.sfgpetclinic.repositories.OwnerRepository;
import eg.bazinga.sfgpetclinic.repositories.PetRepository;
import eg.bazinga.sfgpetclinic.repositories.PetTypeRepository;
import eg.bazinga.sfgpetclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class OwnerJPAService implements OwnerService {

    private OwnerRepository ownerRepository;
    private PetRepository petRepository;
    private PetTypeRepository petTypeRepository;

    @Autowired
    public OwnerJPAService(OwnerRepository ownerRepository,
                           PetRepository petRepository,
                           PetTypeRepository petTypeRepository) {

        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName).orElse(null);
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().iterator().forEachRemaining(owners::add);

        return owners;
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
