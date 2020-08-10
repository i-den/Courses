package com.denchevgod.recipes.converters;

import com.denchevgod.recipes.commands.CategoryCommand;
import com.denchevgod.recipes.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category src) {
        if (src == null) {
            return null;
        }

        final CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(src.getId());
        categoryCommand.setDescription(src.getDescription());
        return categoryCommand;
    }
}
