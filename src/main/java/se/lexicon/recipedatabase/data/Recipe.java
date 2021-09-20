package se.lexicon.recipedatabase.data;

import java.util.List;

public class Recipe {

    private int recipeId;

    private String recipeName;

    private List<RecipeIngredient>recipeIngredients;

    private  RecipeInstruction instruction;

    private List<RecipeCategory>categories;
}
