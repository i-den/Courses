package com.denchevgod.recipes.controllers;

import com.denchevgod.recipes.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;

    public IngredientController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    @RequestMapping("/recipe/{recipeID}/ingredients")
    public String listIngredients(@PathVariable String recipeID, Model model) {
        log.debug("Getting ingredient list for recipe id: " + recipeID);

        model.addAttribute("recipe", recipeService.findCommandByID(Long.valueOf(recipeID)));

        return "recipe/ingredient/list";
    }
}
