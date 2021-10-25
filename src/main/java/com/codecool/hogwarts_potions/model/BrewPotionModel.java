package com.codecool.hogwarts_potions.model;

import java.util.List;

public class BrewPotionModel {
    private long id;
    private String potionName;
    private List<String> ingredients;
    private long studentId;

    public BrewPotionModel(long id, String potionName, List<String> ingredients, long studentId) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
