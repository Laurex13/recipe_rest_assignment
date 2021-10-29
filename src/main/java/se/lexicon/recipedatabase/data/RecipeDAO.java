package se.lexicon.recipedatabase.data;

import se.lexicon.recipedatabase.model.Recipe;
import se.lexicon.recipedatabase.model.RecipeCategory;

import java.util.Collection;

public interface RecipeDAO {

    Recipe findById(Integer recipeId);
    Collection<Recipe> findAll();
    Recipe create(Recipe recipe);
    Recipe update(Recipe recipe);
    void delete(Integer recipeId);
}
