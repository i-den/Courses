package com.denchevgod.petclinic.services.map;

import com.denchevgod.petclinic.model.Owner;
import com.denchevgod.petclinic.model.Pet;
import com.denchevgod.petclinic.services.OwnerService;
import com.denchevgod.petclinic.services.PetService;
import com.denchevgod.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends     AbstractMapService<Owner, Long>
                                implements  OwnerService {

    private final PetTypeService petTypeService;

    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner obj) {
        super.delete(obj);
    }

    @Override
    public Owner save(Owner obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getPets() != null) {
            obj.getPets().forEach(pet -> {
                if (pet.getPetType() != null) {
                    if (pet.getPetType().getId() == null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                } else {
                    throw new RuntimeException("Pet Type is required");
                }

                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }

        return super.save(obj);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        for (Owner owner : super.map.values()) {
            if (owner.getLastName().equals(lastName))
                return owner;
        }
        return null;
    }
}
