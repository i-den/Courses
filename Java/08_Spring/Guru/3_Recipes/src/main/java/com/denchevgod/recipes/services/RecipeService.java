package com.denchevgod.recipes.services;

import com.denchevgod.recipes.commands.RecipeCommand;
import com.denchevgod.recipes.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findByID(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandByID(Long id);

    void deleteByID(Long id);
}
