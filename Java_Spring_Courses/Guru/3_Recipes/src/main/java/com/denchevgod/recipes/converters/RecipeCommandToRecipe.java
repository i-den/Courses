package com.denchevgod.recipes.converters;

import com.denchevgod.recipes.commands.CategoryCommand;
import com.denchevgod.recipes.commands.IngredientCommand;
import com.denchevgod.recipes.commands.RecipeCommand;
import com.denchevgod.recipes.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory          categoryConverter,
                                 IngredientCommandToIngredient      ingredientConverter,
                                 NotesCommandToNotes                notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand src) {
        if (src == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(src.getId());
        recipe.setCookingTime(src.getCookingTime());
        recipe.setPreparationTime(src.getPreparationTime());
        recipe.setDescription(src.getDescription());
        recipe.setDifficulty(src.getDifficulty());
        recipe.setDirections(src.getDirections());
        recipe.setServings(src.getServings());
        recipe.setSource(src.getSource());
        recipe.setUrl(src.getUrl());
        recipe.setNotes(notesConverter.convert(src.getNotes()));

        Set<CategoryCommand> categories = src.getCategories();
        if (categories != null && categories.size() > 0) {
            categories.forEach(c -> recipe.getCategories().add(categoryConverter.convert(c)));
        }

        Set<IngredientCommand> ingredients = src.getIngredients();
        if (ingredients != null && ingredients.size() > 0) {
            ingredients.forEach(i -> recipe.getIngredients().add(ingredientConverter.convert(i)));
        }

        return recipe;
    }
}
