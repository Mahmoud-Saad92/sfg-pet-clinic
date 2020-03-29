package eg.bazinga.sfgpetclinic.services;

public interface OwnerService<T> extends GenericService<T> {

    T findByLastName(String lastName);
}
