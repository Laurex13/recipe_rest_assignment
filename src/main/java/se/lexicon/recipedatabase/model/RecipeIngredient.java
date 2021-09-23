package se.lexicon.recipedatabase.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String recipeIngredientId;

    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.REFRESH,},
            fetch = FetchType.EAGER)
    private Ingredient ingredient;

    private double amount;

    private Measurement measurement;

    @ManyToOne (cascade = {CascadeType.DETACH,CascadeType.REFRESH,},
            fetch = FetchType.EAGER)
    private Recipe recipe;

    protected RecipeIngredient(){

    }

    public RecipeIngredient(String recipeIngredientId, Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {

        this.recipeIngredientId = recipeIngredientId;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public String getRecipeIngredientId() {
        return recipeIngredientId;
    }

    public void setRecipeIngredientId(String recipeIngredientId) {
        this.recipeIngredientId = recipeIngredientId;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Double.compare(that.getAmount(), getAmount()) == 0 && getRecipeIngredientId().equals(that.getRecipeIngredientId()) && getIngredient().equals(that.getIngredient()) && getMeasurement() == that.getMeasurement() && getRecipe().equals(that.getRecipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeIngredientId(), getIngredient(), getAmount(), getMeasurement(), getRecipe());
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeIngredientId='" + recipeIngredientId + '\'' +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", recipe=" + recipe +
                '}';
    }
}
