package eg.bazinga.sfgpetclinic.services;

import eg.bazinga.sfgpetclinic.models.Owner;

public interface OwnerService extends GenericService<Owner, Long> {

    Owner findByLastName(String lastName);
}
