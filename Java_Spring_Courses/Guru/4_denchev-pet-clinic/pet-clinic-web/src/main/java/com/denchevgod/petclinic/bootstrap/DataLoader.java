package com.denchevgod.petclinic.bootstrap;

import com.denchevgod.petclinic.model.*;
import com.denchevgod.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    // JPA Services
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtiesService specialtiesService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int cnt = petTypeService.findAll().size();

        if (cnt == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Specialty s1 = new Specialty();
        s1.setDescription("s1_Desc");
        specialtiesService.save(s1);

        Specialty s2 = new Specialty();
        s2.setDescription("Surgery");
        specialtiesService.save(s2);

        Specialty s3 = new Specialty();
        s3.setDescription("Dentistry");
        specialtiesService.save(s3);

        Owner o1 = new Owner();
        o1.setFirstName("o1_FN");
        o1.setLastName("o1_LN");
        o1.setAddress("o1_Add");
        o1.setCity("o1_City");
        o1.setTelephone("o1_Phone");

        Pet p1 = new Pet();
        p1.setOwner(o1);
        p1.setBirthDate(LocalDate.now());
        p1.setName("p1_Name");
        p1.setPetType(savedDogType);
        o1.getPets().add(p1);

        ownerService.save(o1);

        Owner o2 = new Owner();
        o2.setFirstName("o2_FN");
        o2.setLastName("o2_LN");
        o2.setAddress("o2_Add");
        o2.setCity("o2_City");
        o2.setTelephone("o2_Phone");

        Pet p2 = new Pet();
        p2.setOwner(o2);
        p2.setBirthDate(LocalDate.now());
        p2.setName("p2_Name");
        p2.setPetType(savedCatType);
        o2.getPets().add(p2);

        ownerService.save(o2);

        Visit vs2 = new Visit();
        vs2.setPet(p2);
        vs2.setDate(LocalDate.now());
        visitService.save(vs2);

        Vet v1 = new Vet();
        v1.setFirstName("v1_FN");
        v1.setLastName("v1_LN");
        v1.getSpecialties().add(s1);

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("v2_FN");
        v2.setLastName("v2_LN");
        v2.getSpecialties().add(s2);

        vetService.save(v2);
    }
}
