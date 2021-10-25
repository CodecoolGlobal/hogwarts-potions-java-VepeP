package com.codecool.hogwarts_potions.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Singular;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "potion")
public class Potion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Singular
    @JoinTable
    @ManyToMany
    @EqualsAndHashCode.Exclude
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Ingredient> ingredients = new HashSet<>();

    private BrewingStatus brewingStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "recipe_id", referencedColumnName = "id")
    private Recipe recipe;

    public Potion() {
    }

    public Potion(String name, Student student, Set<Ingredient> ingredients) {
        this.name = name;
        this.student = student;
        this.ingredients = ingredients;
    }

    public Potion(String name, Student student) {
        this.name = name;
        this.student = student;
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

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
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

    public void checkBrewingStatus(Set<Recipe> allRecipes) {
        if (this.ingredients == null || ingredients.size() < 5)
            setBrewingStatus(BrewingStatus.BREW);
        else if (checkIfRecipeAlreadyExists(allRecipes))
            setBrewingStatus(BrewingStatus.REPLICA);
        else
            setBrewingStatus(BrewingStatus.DISCOVERY);
    }

    private boolean checkIfRecipeAlreadyExists(Set<Recipe> allRecipes) {
        for (Recipe recipe : allRecipes)
            if (recipe.hasAllIngredients(this.ingredients)) {
                this.recipe = recipe;
                return true;
            }
        return false;
    }
}
