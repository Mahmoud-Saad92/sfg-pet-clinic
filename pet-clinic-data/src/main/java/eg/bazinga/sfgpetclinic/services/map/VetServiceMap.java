package eg.bazinga.sfgpetclinic.services.map;

import eg.bazinga.sfgpetclinic.models.Speciality;
import eg.bazinga.sfgpetclinic.models.Vet;
import eg.bazinga.sfgpetclinic.services.SpecialityService;
import eg.bazinga.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialityService specialityServiceMap;

    @Autowired
    public VetServiceMap(SpecialityService specialityServiceMap) {
        this.specialityServiceMap = specialityServiceMap;
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet vet) {

        if (!vet.getSpecialities().isEmpty()) {
            vet.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    Speciality savedSpeciality = specialityServiceMap.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }

        return super.save(vet);
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
