package project._a.com.controller;

import project._a.com.entities.Ingredient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecipeDTO {
    private String name;
    private List<Ingredient> ingredients;
}