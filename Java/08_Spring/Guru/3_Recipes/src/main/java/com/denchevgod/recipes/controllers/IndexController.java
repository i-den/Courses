package com.denchevgod.recipes.controllers;

import com.denchevgod.recipes.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/")
    public String getHome(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
