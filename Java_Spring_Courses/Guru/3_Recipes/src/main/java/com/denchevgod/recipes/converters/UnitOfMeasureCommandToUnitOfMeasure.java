package com.denchevgod.recipes.converters;

import com.denchevgod.recipes.commands.UnitOfMeasurementCommand;
import com.denchevgod.recipes.domain.UnitOfMeasurement;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Null;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasurementCommand, UnitOfMeasurement> {

    @Synchronized
    @Null
    @Override
    public UnitOfMeasurement convert(UnitOfMeasurementCommand src) {
        if (src == null) {
            return null;
        }

        final UnitOfMeasurement uom = new UnitOfMeasurement();
        uom.setId(src.getId());
        uom.setDescription(src.getDescription());
        return uom;
    }
}
