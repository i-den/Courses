package com.denchevgod.recipes.converters;

import com.denchevgod.recipes.commands.IngredientCommand;
import com.denchevgod.recipes.domain.Ingredient;
import com.denchevgod.recipes.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }


    @Nullable
    @Override
    public Ingredient convert(IngredientCommand src) {
        if (src == null) {
            return null;
        }

        final Ingredient ingredient = new Ingredient();

        if (src.getRecipeId() != null) {
            Recipe recipe = new Recipe();
            recipe.setId(src.getRecipeId());
            ingredient.setRecipe(recipe);
            recipe.getIngredients().add(ingredient);
        }

        ingredient.setAmount(src.getAmount());
        ingredient.setDescription(src.getDescription());
        ingredient.setUnitOfMeasurement(uomConverter.convert(src.getUom()));
        return ingredient;
    }
}
