package com.denchevgod.recipes.converters;

import com.denchevgod.recipes.commands.CategoryCommand;
import com.denchevgod.recipes.domain.Category;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand src) {
        if (src == null) {
            return null;
        }

        final Category category = new Category();
        category.setId(src.getId());
        category.setDescription(src.getDescription());
        return category;
    }
}
