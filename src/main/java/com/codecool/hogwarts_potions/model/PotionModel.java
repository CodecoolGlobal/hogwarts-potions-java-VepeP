package com.codecool.hogwarts_potions.model;

import com.codecool.hogwarts_potions.entity.Ingredient;
import com.codecool.hogwarts_potions.entity.Recipe;
import com.codecool.hogwarts_potions.entity.Student;
import com.codecool.hogwarts_potions.model.BrewingStatus;

public class PotionModel {
    private long id;
    private String name;
    private Student student;
    private Ingredient ingredients;
    private BrewingStatus brewingStatus;
    private Recipe recipe;

    public PotionModel(long id, String name, Student student, Ingredient ingredients, BrewingStatus brewingStatus, Recipe recipe) {
        this.id = id;
        this.name = name;
        this.student = student;
        this.ingredients = ingredients;
        this.brewingStatus = brewingStatus;
        this.recipe = recipe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Ingredient getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient ingredients) {
        this.ingredients = ingredients;
    }

    public BrewingStatus getBrewingStatus() {
        return brewingStatus;
    }

    public void setBrewingStatus(BrewingStatus brewingStatus) {
        this.brewingStatus = brewingStatus;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
