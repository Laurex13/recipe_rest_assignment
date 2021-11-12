package se.lexicon.recipedatabase.data;

import org.springframework.stereotype.Repository;
import se.lexicon.recipedatabase.model.RecipeInstruction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public class RecipeInstructionDAORepository implements RecipeInstructionDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public RecipeInstruction findById(Integer recipeInstructionId) {
        return entityManager.find(RecipeInstruction.class, recipeInstructionId);
    }

    @Override
    @Transactional
    public Collection<RecipeInstruction> findAll() {
        Query query = entityManager.createQuery("SELECT recipeInstruction FROM RecipeInstruction recipeInstruction",RecipeInstruction.class);
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
    public void deleteBYId(Integer recipeInstructionId) {
        RecipeInstruction deleted = findById(recipeInstructionId);
        if (deleted != null){
            entityManager.remove(deleted);
            System.out.println(recipeInstructionId + "is deleted");
        }else {
            throw new IllegalArgumentException(recipeInstructionId + "not found");
        }

    }
}
