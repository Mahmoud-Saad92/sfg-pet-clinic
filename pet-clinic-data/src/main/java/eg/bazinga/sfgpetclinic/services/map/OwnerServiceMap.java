package eg.bazinga.sfgpetclinic.services.map;

import eg.bazinga.sfgpetclinic.models.Owner;
import eg.bazinga.sfgpetclinic.services.GenericService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements GenericService<Owner, Long> {

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner, owner.getId());
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
}
