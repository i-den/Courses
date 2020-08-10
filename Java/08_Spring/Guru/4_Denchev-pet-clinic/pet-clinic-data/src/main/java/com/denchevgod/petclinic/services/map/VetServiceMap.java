package com.denchevgod.petclinic.services.map;

import com.denchevgod.petclinic.model.Specialty;
import com.denchevgod.petclinic.model.Vet;
import com.denchevgod.petclinic.services.SpecialtiesService;
import com.denchevgod.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap  extends     AbstractMapService<Vet, Long>
                            implements  VetService {

    private SpecialtiesService specialtiesService;

    public VetServiceMap(SpecialtiesService specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet obj) {
        super.delete(obj);
    }

    @Override
    public Vet save(Vet obj) {
        if (obj.getSpecialties().size() > 0) {
            for (Specialty specialty : obj.getSpecialties()) {
                if (specialty.getId() == null) {
                    Specialty savedSpecialty = specialtiesService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            }
        }
        return super.save(obj);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet findByLastName(String lastName) {
        for (Vet vet : super.map.values()) {
            if (vet.getLastName().equals(lastName))
                return vet;
        }
        return null;
    }
}
