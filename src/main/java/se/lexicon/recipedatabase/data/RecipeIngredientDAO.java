package se.lexicon.recipedatabase.data;


import se.lexicon.recipedatabase.model.RecipeIngredient;

import java.util.Collection;

public interface RecipeIngredientDAO  {

    RecipeIngredient findById(int id);
    Collection<RecipeIngredient> findAll();
    RecipeIngredient create(RecipeIngredient recipeIngredient);
    RecipeIngredient update(RecipeIngredient recipeIngredient);
    void delete(int id);

}
