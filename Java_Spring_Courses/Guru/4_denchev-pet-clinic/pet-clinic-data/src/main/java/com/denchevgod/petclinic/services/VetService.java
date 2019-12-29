package com.denchevgod.petclinic.services;

import com.denchevgod.petclinic.model.Vet;

public interface VetService extends CrudService<Vet, Long> {

    Vet findByLastName(String lastName);
}
