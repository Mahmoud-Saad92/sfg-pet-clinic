package eg.bazinga.sfgpetclinic.services.jpa;

import eg.bazinga.sfgpetclinic.models.Owner;
import eg.bazinga.sfgpetclinic.repositories.OwnerRepository;
import eg.bazinga.sfgpetclinic.repositories.PetRepository;
import eg.bazinga.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

    @Mock
    private OwnerRepository ownerRepository;

    @Mock
    private PetRepository petRepository;

    @Mock
    private PetTypeRepository petTypeRepository;

    @InjectMocks
    private OwnerJPAService ownerJPAService;
    
    private String lastName = "saad";
    
    private Optional<Owner> owner;

    @BeforeEach
    void setUp() {
        owner = Optional.of(Owner.builder().id(1l).lastName(lastName).build());
    }

    @Test
    void findByLastName() {
        Mockito.when(ownerRepository.findByLastName(Mockito.any())).thenReturn(owner);

        Owner byLastName = ownerJPAService.findByLastName(lastName);

        assertEquals(lastName, byLastName.getLastName());

        Mockito.verify(ownerRepository, Mockito.times(1)).findByLastName(Mockito.any());
    }

    @Test
    void findById() {
        Mockito.when(ownerRepository.findById(Mockito.any())).thenReturn(owner);

        Owner byId = ownerJPAService.findById(owner.get().getId());

        assertNotNull(byId);
        assertEquals("saad", byId.getLastName());
    }

    @Test
    void findByIdNotFound() {
        Mockito.when(ownerRepository.findById(Mockito.any())).thenReturn(Optional.empty());

        Owner byId = ownerJPAService.findById(1l);

        assertNull(byId);
    }

    @Test
    void save() {
        Mockito.when(ownerRepository.save(Mockito.any())).thenReturn(owner.get());

        Owner save = ownerJPAService.save(Owner.builder().id(3l).build());

        assertNotNull(save);
    }

    @Test
    void findAll() {
        HashSet<Owner> owners = new HashSet<>();
        owners.add(Owner.builder().id(1l).build());
        owners.add(Owner.builder().id(2l).build());

        Mockito.when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> all = ownerJPAService.findAll();

        assertNotNull(all);

        assertEquals(2, all.size());
    }

    @Test
    void delete() {
        ownerJPAService.delete(owner.get());

        Mockito.verify(ownerRepository, Mockito.times(1)).delete(Mockito.any());
    }

    @Test
    void deleteById() {
        ownerJPAService.deleteById(1l);

        Mockito.verify(ownerRepository, Mockito.times(1)).deleteById(Mockito.anyLong());
    }
}