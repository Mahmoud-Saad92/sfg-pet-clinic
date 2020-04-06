package eg.bazinga.sfgpetclinic.services.map;

import eg.bazinga.sfgpetclinic.exceptions.IExceptionMessage;
import eg.bazinga.sfgpetclinic.models.Owner;
import eg.bazinga.sfgpetclinic.models.Pet;
import eg.bazinga.sfgpetclinic.services.OwnerService;
import eg.bazinga.sfgpetclinic.services.PetService;
import eg.bazinga.sfgpetclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private PetTypeService petTypeServiceMap;
    private PetService petServiceMap;

    @Autowired
    public OwnerServiceMap(PetTypeService petTypeServiceMap, PetService petServiceMap) {
        this.petTypeServiceMap = petTypeServiceMap;
        this.petServiceMap = petServiceMap;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            if (owner.getPets() != null) {
                owner.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeServiceMap.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException(IExceptionMessage.PET_TYPE_REQUIRED);
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petServiceMap.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(owner);
        } else {
            throw new RuntimeException(IExceptionMessage.NULL_OBJECT_DETECTED);
        }
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
