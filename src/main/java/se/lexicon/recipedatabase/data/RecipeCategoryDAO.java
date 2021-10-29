package se.lexicon.recipedatabase.data;

import se.lexicon.recipedatabase.model.RecipeCategory;

import java.util.Collection;

public interface RecipeCategoryDAO {

    RecipeCategory findById(Integer recipeCategoryId);
    Collection<RecipeCategory> findAll();
    RecipeCategory create(RecipeCategory recipeCategory);
    RecipeCategory update(RecipeCategory recipeCategory);
    void delete(Integer recipeCategoryId);
}
