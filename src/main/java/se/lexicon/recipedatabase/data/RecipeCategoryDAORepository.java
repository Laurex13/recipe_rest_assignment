package se.lexicon.recipedatabase.data;

import org.springframework.stereotype.Repository;
import se.lexicon.recipedatabase.model.Ingredient;
import se.lexicon.recipedatabase.model.RecipeCategory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class RecipeCategoryDAORepository implements RecipeCategoryDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public RecipeCategory findByNameContain(String name) {
        return entityManager.find(RecipeCategory.class,findByNameContain(name));
    }

    @Override
    @Transactional
    public Collection<RecipeCategory> findAllByIngredientName(String name) {
        Query query = entityManager.createQuery("SELECT c FROM RecipeCategory c", Ingredient.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Collection<RecipeCategory> findAllByRecipeName(String name) {
        Query query = entityManager.createQuery("SELECT c FROM RecipeCategory c",RecipeCategory.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public RecipeCategory findBYRecipe(String recipe) {
        return entityManager.find(RecipeCategory.class,recipe);
    }
}
