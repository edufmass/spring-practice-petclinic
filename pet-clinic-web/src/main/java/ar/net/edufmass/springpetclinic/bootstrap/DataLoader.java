package ar.net.edufmass.springpetclinic.bootstrap;

import ar.net.edufmass.springpetclinic.model.*;
import ar.net.edufmass.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtyService specialtyService,
                      VisitService visitService
    ) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
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

        Visit owner2pet2visit1 = new Visit();
        owner2pet2visit1.setPet(owner2pet2);
        owner2pet2visit1.setDate(LocalDate.now());
        owner2pet2visit1.setDescription("Sneezy kitty");

        visitService.save(owner2pet2visit1);

        System.out.println("Loaded Owners... ");

        Specialty spec1 = new Specialty();
        spec1.setDescription("Radiology");
        Specialty savedSpec1 = specialtyService.save(spec1);

        Specialty spec2 = new Specialty();
        spec2.setDescription("Surgery");
        Specialty savedSpec2 = specialtyService.save(spec2);

        Specialty spec3 = new Specialty();
        spec3.setDescription("Dentistry");
        Specialty savedSpec3 = specialtyService.save(spec3);

        System.out.println("Loaded Specialties... ");

        Vet vet1 = new Vet();
        vet1.setFirstName("Jane");
        vet1.setLastName("Roe");
        vet1.getSpecialties().add(spec1);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Richard");
        vet2.setLastName("Miles");
        vet2.getSpecialties().add(spec2);
        vet2.getSpecialties().add(spec3);
        vetService.save(vet2);

        System.out.println("Loaded Vets... ");
    }
}
