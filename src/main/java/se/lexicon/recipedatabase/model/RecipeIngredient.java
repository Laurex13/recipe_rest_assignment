package se.lexicon.recipedatabase.model;


import java.util.Objects;


public class RecipeIngredient {

    private String recipeIngredient;

    private Ingredient ingredient;

    private double amount;

    private Measurement measurement;

    private Recipe recipe;

    public RecipeIngredient(String recipeIngredient, Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {
        this.recipeIngredient = recipeIngredient;
        this.ingredient = ingredient;
        this.amount = amount;
        this.measurement = measurement;
        this.recipe = recipe;
    }

    public String getRecipeIngredient() {
        return recipeIngredient;
    }

    public void setRecipeIngredient(String recipeIngredient) {
        this.recipeIngredient = recipeIngredient;
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
        return Double.compare(that.getAmount(), getAmount()) == 0 && getRecipeIngredient().equals(that.getRecipeIngredient()) && getIngredient().equals(that.getIngredient()) && getMeasurement() == that.getMeasurement() && getRecipe().equals(that.getRecipe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecipeIngredient(), getIngredient(), getAmount(), getMeasurement(), getRecipe());
    }

    @Override
    public String toString() {
        return "RecipeIngredient{" +
                "recipeIngredient='" + recipeIngredient + '\'' +
                ", ingredient=" + ingredient +
                ", amount=" + amount +
                ", measurement=" + measurement +
                ", recipe=" + recipe +
                '}';
    }
}
