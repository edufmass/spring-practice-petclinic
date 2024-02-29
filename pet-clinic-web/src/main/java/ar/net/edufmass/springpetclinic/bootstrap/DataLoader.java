package ar.net.edufmass.springpetclinic.bootstrap;

import ar.net.edufmass.springpetclinic.model.Owner;
import ar.net.edufmass.springpetclinic.model.PetType;
import ar.net.edufmass.springpetclinic.model.Vet;
import ar.net.edufmass.springpetclinic.services.OwnerService;
import ar.net.edufmass.springpetclinic.services.PetTypeService;
import ar.net.edufmass.springpetclinic.services.VetService;
import ar.net.edufmass.springpetclinic.services.map.OwnerServiceMap;
import ar.net.edufmass.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Mary");
        owner2.setLastName("Major");
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
