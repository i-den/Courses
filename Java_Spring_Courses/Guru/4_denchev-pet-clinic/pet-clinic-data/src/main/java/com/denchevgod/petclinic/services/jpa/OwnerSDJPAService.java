package com.denchevgod.petclinic.services.jpa;

import com.denchevgod.petclinic.model.Owner;
import com.denchevgod.petclinic.repository.OwnerRepository;
import com.denchevgod.petclinic.repository.PetRepository;
import com.denchevgod.petclinic.repository.PetTypeRepository;
import com.denchevgod.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJPAService implements OwnerService {

    private final OwnerRepository ownerRepository;

    private final PetRepository petRepository;

    private final PetTypeRepository petTypeRepository;

    public OwnerSDJPAService(OwnerRepository    ownerRepository,
                             PetRepository      petRepository,
                             PetTypeRepository  petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    @Override
    public Owner save(Owner obj) {
        return ownerRepository.save(obj);
    }

    @Override
    public void delete(Owner obj) {
        ownerRepository.delete(obj);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
