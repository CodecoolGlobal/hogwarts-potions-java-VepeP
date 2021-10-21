package com.codecool.hogwarts_potions.model;

import java.util.List;

public class IngredientModel {
    private List<String> ingredients;
    private long studentId;

    public IngredientModel(List<String> ingredients, long studentId) {
        this.ingredients = ingredients;
        this.studentId = studentId;
    }

    public IngredientModel() {
    }

    public void addIngredient(String ingredient){
        this.ingredients.add(ingredient);
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
}
