package eg.bazinga.sfgpetclinic.services.map;

import eg.bazinga.sfgpetclinic.exceptions.IExceptionMessage;
import eg.bazinga.sfgpetclinic.models.Visit;
import eg.bazinga.sfgpetclinic.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {

    private PetServiceMap petServiceMap;

    @Autowired
    public VisitServiceMap(PetServiceMap petServiceMap) {
        this.petServiceMap = petServiceMap;
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit != null) {
            if (visit.getPet() != null && visit.getPet().getOwner() != null && visit.getPet().getOwner().getId() != null) {
                if (visit.getPet().getId() == null) {
                    visit.setPet(petServiceMap.save(visit.getPet()));
                }
            } else {
                throw new RuntimeException(IExceptionMessage.PET_REQUIRED);
            }

            return super.save(visit);
        } else {
            throw new RuntimeException(IExceptionMessage.NULL_OBJECT_DETECTED);
        }
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }
}
