package ar.net.edufmass.springpetclinic.bootstrap;

import ar.net.edufmass.springpetclinic.model.Owner;
import ar.net.edufmass.springpetclinic.model.Vet;
import ar.net.edufmass.springpetclinic.services.OwnerService;
import ar.net.edufmass.springpetclinic.services.VetService;
import ar.net.edufmass.springpetclinic.services.map.OwnerServiceMap;
import ar.net.edufmass.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
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
