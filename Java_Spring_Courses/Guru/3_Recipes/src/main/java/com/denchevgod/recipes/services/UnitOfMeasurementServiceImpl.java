package com.denchevgod.recipes.services;

import com.denchevgod.recipes.commands.UnitOfMeasurementCommand;
import com.denchevgod.recipes.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.denchevgod.recipes.repository.UnitOfMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UnitOfMeasurementServiceImpl implements UnitOfMeasurementService{

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasurementServiceImpl(UnitOfMeasureRepository                 unitOfMeasureRepository,
                                        UnitOfMeasureToUnitOfMeasureCommand     unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }


    @Override
    public Set<UnitOfMeasurementCommand> listAllUoms() {

        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                .spliterator(), false)
                .map(unitOfMeasureToUnitOfMeasureCommand::convert)
                .collect(Collectors.toSet());
    }
}
