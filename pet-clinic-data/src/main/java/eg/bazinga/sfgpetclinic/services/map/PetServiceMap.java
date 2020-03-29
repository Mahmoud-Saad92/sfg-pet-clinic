package eg.bazinga.sfgpetclinic.services.map;

import eg.bazinga.sfgpetclinic.models.Pet;
import eg.bazinga.sfgpetclinic.services.GenericService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements GenericService<Pet, Long> {
    
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet, pet.getId());
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }
}
