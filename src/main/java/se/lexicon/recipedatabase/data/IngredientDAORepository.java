package se.lexicon.recipedatabase.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import se.lexicon.recipedatabase.model.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class IngredientDAORepository implements IngredientDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public IngredientDAORepository(EntityManager entityManager){

    }


    @Override
    @Transactional
    public Ingredient findById(Integer ingredientId) {
        return entityManager.find(Ingredient.class,ingredientId);
    }

    @Override
    @Transactional
    public Collection<Ingredient> findAll() {
        return entityManager.createQuery("SELECT ingredient FROM Ingredient ingredient", Ingredient.class).getResultList();
    }

    @Override
    @Transactional
    public Ingredient create(Ingredient ingredient) {
        entityManager.persist(ingredient);
        return ingredient;
    }

    @Override
    @Transactional
    public Ingredient update(Ingredient ingredient) {
        return entityManager.merge(ingredient);
    }

    @Override
    @Transactional
    public void delete(Integer ingredientId) {
        Ingredient deleted =findById(ingredientId);
        if (deleted != null){
            entityManager.remove(deleted);
            System.out.println(ingredientId + "is deleted");
        }else {
            throw new IllegalArgumentException(ingredientId + "not found");
        }

    }
}
