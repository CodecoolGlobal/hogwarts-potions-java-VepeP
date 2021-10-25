package com.codecool.hogwarts_potions.model;

import com.codecool.hogwarts_potions.entity.Ingredient;
import com.codecool.hogwarts_potions.entity.Potion;
import com.codecool.hogwarts_potions.entity.Recipe;
import com.codecool.hogwarts_potions.entity.Student;
import com.codecool.hogwarts_potions.model.BrewingStatus;

import java.util.Set;

public class PotionModel {
    private long id;
    private String name;
    private Student student;
    private Set<Ingredient> ingredients;
    private BrewingStatus brewingStatus;
    private Recipe recipe;

    public PotionModel(Potion potion) {
        this.id = potion.getId();
        this.name = potion.getName();
        this.student = potion.getStudent();
        this.ingredients = potion.getIngredients();
        this.brewingStatus = potion.getBrewingStatus();
        this.recipe = potion.getRecipe();
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

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

}
