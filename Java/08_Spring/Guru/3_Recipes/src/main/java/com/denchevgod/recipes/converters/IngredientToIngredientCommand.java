package com.denchevgod.recipes.converters;

import com.denchevgod.recipes.commands.IngredientCommand;
import com.denchevgod.recipes.domain.Ingredient;
import com.denchevgod.recipes.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Null;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

   private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Synchronized
    @Null
    @Override
    public IngredientCommand convert(Ingredient src) {
        if (src == null) {
            return null;
        }

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(src.getId());

        Recipe recipe = src.getRecipe();
        if (recipe != null) {
            ingredientCommand.setRecipeId(recipe.getId());
        }
        ingredientCommand.setAmount(src.getAmount());
        ingredientCommand.setDescription(src.getDescription());
        ingredientCommand.setUom(uomConverter.convert(src.getUnitOfMeasurement()));
        return ingredientCommand;
    }
}
