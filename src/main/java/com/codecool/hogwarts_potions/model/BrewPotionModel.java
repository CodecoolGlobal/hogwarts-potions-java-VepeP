package com.codecool.hogwarts_potions.model;

import java.util.List;

public class BrewPotionModel {
    private String potionName;
    private List<String> ingredients;
    private long studentId;

    public BrewPotionModel(String potionName, List<String> ingredients, long studentId) {
        this.potionName = potionName;
        this.ingredients = ingredients;
        this.studentId = studentId;
    }

    public BrewPotionModel() {
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

    public String getPotionName() {
        return potionName;
    }

    public void setPotionName(String potionName) {
        this.potionName = potionName;
    }
}
