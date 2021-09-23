package se.lexicon.recipedatabase.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipeId;

    private String recipeName;

    @OneToMany (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,},
    fetch = FetchType.LAZY,orphanRemoval = true,mappedBy = "RecipeCategory")
    private List<RecipeIngredient>recipeIngredients;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private  RecipeInstruction instruction;

    @OneToMany (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,},
            fetch = FetchType.LAZY)
    private List<RecipeCategory>categories;

    public Recipe(int recipeId, String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.instruction = instruction;
        this.categories = categories;
    }

    public Recipe() {

    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public RecipeInstruction getInstruction() {
        return instruction;
    }

    public void setInstruction(RecipeInstruction instruction) {
        this.instruction = instruction;
    }

    public List<RecipeCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return getRecipeId() == recipe.getRecipeId() && getRecipeName().equals(recipe.getRecipeName()) && getRecipeIngredients().equals(recipe.getRecipeIngredients()) && getInstruction().equals(recipe.getInstruction()) && getCategories().equals(recipe.getCategories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeId(), getRecipeName(), getRecipeIngredients(), getInstruction(), getCategories());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", instruction=" + instruction +
                ", categories=" + categories +
                '}';
    }
}
