package eg.bazinga.sfgpetclinic.bootstrap;

import eg.bazinga.sfgpetclinic.models.Owner;
import eg.bazinga.sfgpetclinic.models.Pet;
import eg.bazinga.sfgpetclinic.models.PetType;
import eg.bazinga.sfgpetclinic.models.Vet;
import eg.bazinga.sfgpetclinic.services.OwnerService;
import eg.bazinga.sfgpetclinic.services.PetTypeService;
import eg.bazinga.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerServiceMap;
    private VetService vetServiceMap;
    private PetTypeService petTypeServiceMap;

    @Autowired
    public DataLoader(OwnerService ownerServiceMap, VetService vetServiceMap, PetTypeService petTypeServiceMap) {
        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
        this.petTypeServiceMap = petTypeServiceMap;
    }

    @Override
    public void run(String... args) {

        PetType dog = new PetType();
        dog.setName("Dog");
        dog = petTypeServiceMap.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        cat = petTypeServiceMap.save(cat);

        Owner ownerOne = new Owner();
        ownerOne.setFirstName("Mahmoud");
        ownerOne.setLastName("Saad");
        ownerOne.setAddress("32 Mohamed St.");
        ownerOne.setCity("Mansoura");
        ownerOne.setTelephone("010154633");

        setPet(cat, ownerOne, "Possy");

        ownerServiceMap.save(ownerOne);

        Owner ownerTwo = new Owner();
        ownerTwo.setFirstName("Dina");
        ownerTwo.setLastName("Medhat");
        ownerTwo.setAddress("5 Medhat St.");
        ownerTwo.setCity("Damita");
        ownerTwo.setTelephone("0103457324");

        setPet(dog, ownerTwo, "Rix");

        ownerServiceMap.save(ownerTwo);

        System.out.println("Owners Loaded ...");

        Vet vetOne = new Vet();
        vetOne.setFirstName("Sam");
        vetOne.setLastName("Axe");

        vetServiceMap.save(vetOne);

        Vet vetTwo = new Vet();
        vetTwo.setFirstName("Sam");
        vetTwo.setLastName("Axe");

        vetServiceMap.save(vetTwo);

        System.out.println("Vets Loaded ...");

    }

    private void setPet(PetType type, Owner owner, String name) {
        Pet pet = new Pet();
        pet.setPetType(type);
        pet.setBirthday(LocalDate.now());
        pet.setName(name);
        pet.setOwner(owner);
        owner.getPets().add(pet);
    }
}
