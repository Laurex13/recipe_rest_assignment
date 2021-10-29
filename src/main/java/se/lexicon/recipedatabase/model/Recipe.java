package se.lexicon.recipedatabase.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private int recipeId;

    private String recipeName;

    @OneToMany (cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,CascadeType.PERSIST},
    fetch = FetchType.LAZY,mappedBy = "recipe")
    private List<RecipeIngredient>recipeIngredients;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_instruction_id")
    private  RecipeInstruction recipeInstruction;

    @ManyToMany (cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST, CascadeType.REFRESH,},
            fetch = FetchType.LAZY,mappedBy = "recipes")
    private List<RecipeCategory>recipeCategories;

    public Recipe(int recipeId, String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction recipeInstruction, List<RecipeCategory> recipeCategories) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeInstruction = recipeInstruction;
        this.recipeCategories = recipeCategories;
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

    public RecipeInstruction getRecipeInstruction() {
        return recipeInstruction;
    }

    public void setRecipeInstruction(RecipeInstruction recipeInstruction) {
        this.recipeInstruction = recipeInstruction;
    }

    public List<RecipeCategory> getRecipeCategories() {
        return recipeCategories;
    }

    public void setRecipeCategories(List<RecipeCategory> recipeCategories) {
        this.recipeCategories = recipeCategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return recipeId == recipe.recipeId && recipeName.equals(recipe.recipeName) && recipeIngredients.equals(recipe.recipeIngredients) && recipeInstruction.equals(recipe.recipeInstruction) && recipeCategories.equals(recipe.recipeCategories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, recipeName, recipeIngredients, recipeInstruction, recipeCategories);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", recipeName='" + recipeName + '\'' +
                ", recipeIngredients=" + recipeIngredients +
                ", recipeInstruction=" + recipeInstruction +
                ", recipeCategories=" + recipeCategories +
                '}';
    }
}

