package ar.net.edufmass.springpetclinic.bootstrap;

import ar.net.edufmass.springpetclinic.model.Owner;
import ar.net.edufmass.springpetclinic.model.Pet;
import ar.net.edufmass.springpetclinic.model.PetType;
import ar.net.edufmass.springpetclinic.model.Vet;
import ar.net.edufmass.springpetclinic.services.OwnerService;
import ar.net.edufmass.springpetclinic.services.PetTypeService;
import ar.net.edufmass.springpetclinic.services.VetService;
import ar.net.edufmass.springpetclinic.services.map.OwnerServiceMap;
import ar.net.edufmass.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded PetTypes... ");

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Doe");
        owner1.setAddress("123 Some Street");
        owner1.setCity("Spring City");
        owner1.setTelephone("123123123");

        Pet owner1pet1 = new Pet();
        owner1pet1.setName("Loki");
        owner1pet1.setPetType(savedDogPetType);
        owner1pet1.setOwner(owner1);
        owner1pet1.setBirthDate(LocalDate.now());

        owner1.getPets().add(owner1pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mary");
        owner2.setLastName("Major");
        owner2.setAddress("456 Other Street");
        owner2.setCity("Spring City");
        owner2.setTelephone("111222333");

        Pet owner2pet1 = new Pet();
        owner2pet1.setName("Milo");
        owner2pet1.setPetType(savedCatPetType);
        owner2pet1.setOwner(owner2);
        owner2pet1.setBirthDate(LocalDate.now());

        Pet owner2pet2 = new Pet();
        owner2pet2.setName("Luna");
        owner2pet2.setPetType(savedCatPetType);
        owner2pet2.setOwner(owner2);
        owner2pet2.setBirthDate(LocalDate.now());

        owner2.getPets().add(owner2pet1);
        owner2.getPets().add(owner2pet2);

        ownerService.save(owner2);

        System.out.println("Loaded Owners... ");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jane");
        vet1.setLastName("Roe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Richard");
        vet2.setLastName("Miles");
        vetService.save(vet2);

        System.out.println("Loaded Vets... ");
    }
}
