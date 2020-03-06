package com.denchevgod.petclinic.repository;

import com.denchevgod.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {

    Vet findByLastName(String lastName);
}
