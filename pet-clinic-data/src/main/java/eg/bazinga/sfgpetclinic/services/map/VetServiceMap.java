package eg.bazinga.sfgpetclinic.services.map;

import eg.bazinga.sfgpetclinic.models.Vet;
import eg.bazinga.sfgpetclinic.services.GenericService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements GenericService<Vet, Long> {

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet, vet.getId());
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
