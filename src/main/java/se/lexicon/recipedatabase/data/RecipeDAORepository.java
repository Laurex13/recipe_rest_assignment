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
public class RecipeDAORepository implements RecipeDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public Recipe findByNameContain(String name) {
        return entityManager.find(Recipe.class,findByNameContain(name));
    }

    @Override
    @Transactional
    public Collection<Recipe> findAllByIngredientName(String name) {
        Query query = entityManager.createQuery("SELECT a FROM Recipe a", Ingredient.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Collection<Recipe> findAllByRecipeCategory(String name) {
        Query query = entityManager.createQuery("SELECT a FROM Recipe a", RecipeCategory.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Collection<Recipe> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM Recipe a",Recipe.class);
        return query.getResultList();
    }
}
