package com.denchevgod.recipes.services;

import com.denchevgod.recipes.commands.RecipeCommand;
import com.denchevgod.recipes.converters.RecipeCommandToRecipe;
import com.denchevgod.recipes.converters.RecipeToRecipeCommand;
import com.denchevgod.recipes.domain.Recipe;
import com.denchevgod.recipes.exceptions.NotFoundException;
import com.denchevgod.recipes.repository.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository       recipeRepository,
                             RecipeCommandToRecipe  recipeCommandToRecipe,
                             RecipeToRecipeCommand  recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().forEach(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findByID(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (!recipeOptional.isPresent()) {
           throw new NotFoundException("Recipe with ID " + id + " not found!");
            //throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Str");
        }
        return recipeOptional.get();
    }

    @Override
    @Transactional
    public RecipeCommand findCommandByID(Long id) {
        return recipeToRecipeCommand.convert(findByID(id));
    }

    @Override
    public void deleteByID(Long id) {
        recipeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);
        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved Recipe with ID: " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }


}
