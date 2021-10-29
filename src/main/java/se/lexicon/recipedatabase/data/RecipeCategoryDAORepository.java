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
public class RecipeCategoryDAORepository implements RecipeCategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public RecipeCategory findById(Integer recipeCategoryId) {
        return entityManager.find(RecipeCategory.class,recipeCategoryId);
    }

    @Override
    public Collection<RecipeCategory> findAll() {
        return entityManager.createQuery("SELECT recipeCategory FROM RecipeCategory recipeCategory",RecipeCategory.class).getResultList();
    }

    @Override
    public RecipeCategory create(RecipeCategory recipeCategory) {
         entityManager.persist(recipeCategory);
         return recipeCategory;
    }

    @Override
    public RecipeCategory update(RecipeCategory recipeCategory) {
        return entityManager.merge(recipeCategory);
    }

    @Override
    public void delete(Integer recipeCategoryId) {
        RecipeCategory deleted = findById(recipeCategoryId);
        if (deleted != null){
            entityManager.remove(deleted);
            System.out.println(recipeCategoryId + "is deleted");
        }else {
            throw new IllegalArgumentException(recipeCategoryId + "not found");
        }


    }
}
