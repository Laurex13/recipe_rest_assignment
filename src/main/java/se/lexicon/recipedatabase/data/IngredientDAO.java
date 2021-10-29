package se.lexicon.recipedatabase.data;

import se.lexicon.recipedatabase.model.Ingredient;

import java.util.Collection;

public interface IngredientDAO {

    Ingredient findById(Integer ingredientId);
    Collection<Ingredient> findAll();
    Ingredient create(Ingredient ingredient);
    Ingredient update(Ingredient ingredient);
    void delete(Integer ingredientId);
}
