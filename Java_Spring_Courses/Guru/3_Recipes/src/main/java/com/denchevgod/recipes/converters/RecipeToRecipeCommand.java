package com.denchevgod.recipes.converters;

import com.denchevgod.recipes.commands.RecipeCommand;
import com.denchevgod.recipes.domain.Category;
import com.denchevgod.recipes.domain.Ingredient;
import com.denchevgod.recipes.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final CategoryToCategoryCommand categoryConverter;
    private final IngredientToIngredientCommand ingredientConverter;
    private final NotesToNotesCommand notesConverter;

    public RecipeToRecipeCommand(CategoryToCategoryCommand categoryConverter,
                                 IngredientToIngredientCommand ingredientConverter,
                                 NotesToNotesCommand notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public RecipeCommand convert(Recipe src) {
        if (src == null) {
            return null;
        }

        final RecipeCommand command = new RecipeCommand();
        command.setId(src.getId());
        command.setCookingTime(src.getCookingTime());
        command.setDescription(src.getDescription());
        command.setDifficulty(src.getDifficulty());
        command.setDirections(src.getDirections());
        command.setServings(src.getServings());
        command.setSource(src.getSource());
        command.setUrl(src.getUrl());
        command.setImage(src.getImage());
        command.setNotes(notesConverter.convert(src.getNotes()));

        Set<Category> categories = src.getCategories();
        if (categories != null && categories.size() > 0) {
            categories.forEach(c -> command.getCategories().add(categoryConverter.convert(c)));
        }

        Set<Ingredient> ingredients = src.getIngredients();
        if (ingredients != null && ingredients.size() > 0) {
            ingredients.forEach(i -> command.getIngredients().add(ingredientConverter.convert(i)));
        }

        return command;
    }
}
