package se.lexicon.recipedatabase.data;

import org.springframework.stereotype.Repository;
import se.lexicon.recipedatabase.model.RecipeIngredient;
import se.lexicon.recipedatabase.model.RecipeInstruction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class RecipeInstructionDAORepository implements RecipeInstructionDAO{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public RecipeInstruction findById(int id) {
        return entityManager.find(RecipeInstruction.class,id);
    }

    @Override
    @Transactional
    public Collection<RecipeInstruction> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM RecipeInstruction b",RecipeInstruction.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public RecipeInstruction create(RecipeInstruction recipeInstruction) {
        entityManager.persist(recipeInstruction);
        return recipeInstruction;
    }

    @Override
    @Transactional
    public RecipeInstruction update(RecipeInstruction recipeInstruction) {
        return entityManager.merge(recipeInstruction);
    }

    @Override
    @Transactional
    public void deleteBYId(int id) {
        entityManager.remove(findById(id));

    }
}
