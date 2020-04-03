package eg.bazinga.sfgpetclinic.services.map;

import eg.bazinga.sfgpetclinic.exceptions.IExceptionMessage;
import eg.bazinga.sfgpetclinic.models.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T t) {

        if (t != null) {
            if (t.getId() == null) {
                t.setId(getNextID());
            }
            map.put(t.getId(), t);
        } else {
            throw new RuntimeException(IExceptionMessage.NULL_OBJECT_DETECTED);
        }

        return t;
    }

    void delete(T t) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    private Long getNextID() {
        return  !(map.isEmpty()) ? Collections.max(map.keySet()) + 1 : 1L;
    }
}
