package se.lexicon.recipedatabase.data;


import se.lexicon.recipedatabase.model.RecipeIngredient;
import se.lexicon.recipedatabase.model.RecipeInstruction;

import java.util.Collection;

public interface RecipeInstructionDAO {

    RecipeInstruction findById(int id);
    Collection<RecipeInstruction> findAll();
    RecipeInstruction create(RecipeInstruction recipeInstruction);
    RecipeInstruction update(RecipeInstruction recipeInstruction);
    void deleteBYId (int id);



}
