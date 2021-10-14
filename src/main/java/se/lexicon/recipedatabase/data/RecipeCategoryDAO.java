package se.lexicon.recipedatabase.data;

import se.lexicon.recipedatabase.model.RecipeCategory;

import java.util.Collection;

public interface RecipeCategoryDAO {

    RecipeCategory findByNameContain (String name);

    Collection<RecipeCategory>findAllByIngredientName(String name);

    Collection<RecipeCategory>findAllByRecipeName(String name);

    RecipeCategory findBYRecipe(String recipe);
}
