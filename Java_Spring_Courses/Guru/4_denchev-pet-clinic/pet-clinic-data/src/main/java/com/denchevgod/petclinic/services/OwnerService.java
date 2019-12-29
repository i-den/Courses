package com.denchevgod.petclinic.services;

import com.denchevgod.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
