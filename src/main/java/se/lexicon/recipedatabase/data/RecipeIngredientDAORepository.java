package se.lexicon.recipedatabase.data;

import org.springframework.stereotype.Repository;
import se.lexicon.recipedatabase.model.RecipeIngredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;


@Repository
public class RecipeIngredientDAORepository implements RecipeIngredientDAO{

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public RecipeIngredient findById(int id) {
        return entityManager.find(RecipeIngredient.class, id);
    }

    @Override
    @Transactional
    public Collection<RecipeIngredient> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM RecipeIngredient b",RecipeIngredient.class);
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
    public void delete (int id){
        entityManager.remove(findById(id));
    }
}
