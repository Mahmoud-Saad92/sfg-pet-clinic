package eg.bazinga.sfgpetclinic.bootstrap;

import eg.bazinga.sfgpetclinic.models.*;
import eg.bazinga.sfgpetclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerServiceMap;
    private VetService vetServiceMap;
    private PetTypeService petTypeServiceMap;
    private SpecialityService specialityServiceMap;
    private VisitService visitServiceMap;

    @Autowired
    public DataLoader(OwnerService ownerServiceMap,
                      VetService vetServiceMap,
                      PetTypeService petTypeServiceMap,
                      SpecialityService specialityServiceMap,
                      VisitService visitServiceMap) {

        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
        this.petTypeServiceMap = petTypeServiceMap;
        this.specialityServiceMap = specialityServiceMap;
        this.visitServiceMap = visitServiceMap;
    }

    @Override
    public void run(String... args) {

        if (petTypeServiceMap.findAll().isEmpty()) {
            loadData();
        }

    }

    private void loadData() {
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

        Pet possy = setPet(cat, ownerOne, "Possy");

        ownerServiceMap.save(ownerOne);

        Owner ownerTwo = new Owner();
        ownerTwo.setFirstName("Dina");
        ownerTwo.setLastName("Medhat");
        ownerTwo.setAddress("5 Medhat St.");
        ownerTwo.setCity("Damita");
        ownerTwo.setTelephone("0103457324");

        Pet rix = setPet(dog, ownerTwo, "Rix");

        ownerServiceMap.save(ownerTwo);

        Visit catVisit = new Visit();
        catVisit.setDescription("cat visit WTF !!");
        catVisit.setDate(LocalDate.now());
        catVisit.setPet(possy);

        visitServiceMap.save(catVisit);

        Vet vetOne = new Vet();
        vetOne.setFirstName("Sam");
        vetOne.setLastName("Axe");
        vetOne.getSpecialities().add(setSpecialties("Radiology"));

        vetServiceMap.save(vetOne);

        Vet vetTwo = new Vet();
        vetTwo.setFirstName("Sam");
        vetTwo.setLastName("Axe");
        vetTwo.getSpecialities().add(setSpecialties("Surgery"));

        vetServiceMap.save(vetTwo);

        System.out.println("Data Loaded ...");
    }

    private Pet setPet(PetType type, Owner owner, String name) {
        Pet pet = new Pet();
        pet.setPetType(type);
        pet.setBirthday(LocalDate.now());
        pet.setName(name);
        pet.setOwner(owner);
        owner.getPets().add(pet);

        return pet;
    }

    private Speciality setSpecialties(String description) {
        Speciality speciality = new Speciality();
        speciality.setDescription(description);
        return specialityServiceMap.save(speciality);
    }
}
