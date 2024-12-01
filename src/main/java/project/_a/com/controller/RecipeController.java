package project._a.com.controller;

import project._a.com.entities.Ingredient;
import project._a.com.entities.Recipe;
import project._a.com.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody RecipeDTO recipeDTO) {
        List<Ingredient> ingredients = recipeDTO.getIngredients();
        return recipeService.createRecipe(recipeDTO.getName(), ingredients);
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping("/search")
    public List<Recipe> findRecipesByIngredients(@RequestBody List<String> ingredients) {
        return recipeService.findRecipesByIngredients(ingredients);
    }
}