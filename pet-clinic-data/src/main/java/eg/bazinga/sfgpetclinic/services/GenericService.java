package eg.bazinga.sfgpetclinic.services;

import java.util.Set;

public interface GenericService<T> {

    T findById(Long id);

    T save(T t);

    Set<T> findAll();
}
