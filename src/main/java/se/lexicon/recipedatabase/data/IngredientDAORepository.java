package se.lexicon.recipedatabase.data;

import org.springframework.stereotype.Repository;
import se.lexicon.recipedatabase.model.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class IngredientDAORepository implements IngredientDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Ingredient findBYIngredientName(String ingredientName) {
        return entityManager.find(Ingredient.class,ingredientName);
    }
}
