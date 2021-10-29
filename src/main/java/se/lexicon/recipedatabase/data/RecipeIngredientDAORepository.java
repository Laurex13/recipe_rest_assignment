package se.lexicon.recipedatabase.data;

import org.springframework.stereotype.Repository;
import se.lexicon.recipedatabase.model.Recipe;
import se.lexicon.recipedatabase.model.RecipeIngredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;


@Repository
public class RecipeIngredientDAORepository implements RecipeIngredientDAO{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public RecipeIngredient findById(Integer recipeIngredientId) {
        return entityManager.find(RecipeIngredient.class, recipeIngredientId);
    }

    @Override
    @Transactional
    public Collection<RecipeIngredient> findAll() {
        Query query = entityManager.createQuery("SELECT recipeIngredient FROM RecipeIngredient recipeIngredient",RecipeIngredient.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public RecipeIngredient create(RecipeIngredient recipeIngredient) {
        entityManager.persist(recipeIngredient);
        return recipeIngredient;
    }

    @Override
    @Transactional
    public RecipeIngredient update(RecipeIngredient recipeIngredient) {

        return entityManager.merge(recipeIngredient);
    }

    @Override
    public void delete(Integer recipeIngredientId) {
        RecipeIngredient deleted = findById(recipeIngredientId);
        if (deleted != null){
            entityManager.remove(deleted);
            System.out.println(recipeIngredientId + "is deleted");
        }else {
            throw new IllegalArgumentException(recipeIngredientId + "not found");
        }

    }
}
