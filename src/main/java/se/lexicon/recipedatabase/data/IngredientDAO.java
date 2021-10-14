package se.lexicon.recipedatabase.data;

import se.lexicon.recipedatabase.model.Ingredient;

import java.util.Collection;

public interface IngredientDAO {

    Ingredient findBYIngredientName(String ingredientName);
}
