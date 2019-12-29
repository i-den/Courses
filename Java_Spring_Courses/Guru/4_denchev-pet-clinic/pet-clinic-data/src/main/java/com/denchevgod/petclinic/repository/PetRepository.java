package com.denchevgod.petclinic.repository;

import com.denchevgod.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
