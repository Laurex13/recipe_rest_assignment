package se.lexicon.recipedatabase.data;

import org.springframework.stereotype.Repository;
import se.lexicon.recipedatabase.model.Ingredient;
import se.lexicon.recipedatabase.model.Recipe;
import se.lexicon.recipedatabase.model.RecipeCategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class RecipeDAORepository implements RecipeDAO {

     @PersistenceContext
   private EntityManager entityManager;



    @Override
    @Transactional
    public Recipe findById(Integer recipeId) {
        return entityManager.find(Recipe.class,recipeId);
    }

    @Override
    @Transactional
    public Collection<Recipe> findAll() {
        return entityManager.createQuery("SELECT recipe FROM Recipe recipe",Recipe.class).getResultList();
    }

    @Override
    @Transactional
    public Recipe create(Recipe recipe) {
        entityManager.persist(recipe);
        return recipe;
    }

    @Override
    @Transactional
    public Recipe update(Recipe recipe) {
        return entityManager.merge(recipe);
    }

    @Override
    @Transactional
    public void delete(Integer recipeId) {
        Recipe deleted = findById(recipeId);
        if (deleted != null){
            entityManager.remove(deleted);
            System.out.println(recipeId + "is deleted");
        }else {
            throw new IllegalArgumentException(recipeId + "not found");
        }


    }


}