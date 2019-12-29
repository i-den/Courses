package com.denchevgod.recipes.services;

import com.denchevgod.recipes.commands.UnitOfMeasurementCommand;

import java.util.Set;

public interface UnitOfMeasurementService {

    Set<UnitOfMeasurementCommand> listAllUoms();
}
