package eg.bazinga.sfgpetclinic.bootstrap;

import eg.bazinga.sfgpetclinic.models.Owner;
import eg.bazinga.sfgpetclinic.models.Vet;
import eg.bazinga.sfgpetclinic.services.OwnerService;
import eg.bazinga.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerServiceMap;
    private VetService vetServiceMap;

    @Autowired
    public DataLoader(OwnerService ownerServiceMap, VetService vetServiceMap) {
        this.ownerServiceMap = ownerServiceMap;
        this.vetServiceMap = vetServiceMap;
    }

    @Override
    public void run(String... args) {

        Owner ownerOne = new Owner();
        ownerOne.setFirstName("Mahmoud");
        ownerOne.setLastName("Saad");

        ownerServiceMap.save(ownerOne);

        Owner ownerTwo = new Owner();
        ownerTwo.setFirstName("Dina");
        ownerTwo.setLastName("Medhat");

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
}
