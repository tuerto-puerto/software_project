package project._a.com.service;


import project._a.com.entities.Ingredient;
import project._a.com.entities.Recipe;
import project._a.com.repository.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Transactional
    public Recipe createRecipe(String name, List<Ingredient> ingredients) {
        Recipe recipe = new Recipe(name);
        recipe.setIngredients(ingredients);
        for (Ingredient ingredient : ingredients) {
            ingredient.setRecipe(recipe);
        }
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
    @Transactional
    public List<Recipe> findRecipesByIngredients(List<String> ingredients) {
        return recipeRepository.findRecipesByIngredients(ingredients, ingredients.size());
    }

}

