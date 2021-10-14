package se.lexicon.recipedatabase.data;

import se.lexicon.recipedatabase.model.Recipe;
import se.lexicon.recipedatabase.model.RecipeCategory;

import java.util.Collection;

public interface RecipeDAO {

    Recipe findByNameContain (String name);

    Collection<Recipe>findAllByIngredientName(String name);

    Collection<Recipe>findAllByRecipeCategory(String name);

    Collection<Recipe> findAll();

}
