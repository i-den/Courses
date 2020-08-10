package com.denchevgod.recipes.converters;

import com.denchevgod.recipes.commands.UnitOfMeasurementCommand;
import com.denchevgod.recipes.domain.UnitOfMeasurement;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasurement, UnitOfMeasurementCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasurementCommand convert(UnitOfMeasurement src) {
        if (src == null) {
            return null;
        }

        final UnitOfMeasurementCommand uomc = new UnitOfMeasurementCommand();
        uomc.setId(src.getId());
        uomc.setDescription(src.getDescription());
        return uomc;
    }
}
