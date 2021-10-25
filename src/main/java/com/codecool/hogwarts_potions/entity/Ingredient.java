package com.codecool.hogwarts_potions.entity;

import lombok.EqualsAndHashCode;
import lombok.Singular;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToMany(mappedBy = "ingredients")
    @Singular
    @EqualsAndHashCode.Exclude
    private Set<Recipe> recipes = new HashSet<>();

    @ManyToMany(mappedBy = "ingredients")
    @Singular
    @EqualsAndHashCode.Exclude
    private Set<Potion> potions = new HashSet<>();

    public Ingredient() {
    }

    public Ingredient(String name) {
        this.name = name;
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

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    public Set<Potion> getPotions() {
        return potions;
    }

    public void setPotions(Set<Potion> potions) {
        this.potions = potions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
