package eg.bazinga.sfgpetclinic.services;

public interface OwnerService<T, ID> extends GenericService<T, ID> {

    T findByLastName(String lastName);
}
