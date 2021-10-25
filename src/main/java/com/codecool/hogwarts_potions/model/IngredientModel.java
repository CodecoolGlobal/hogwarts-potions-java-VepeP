package com.codecool.hogwarts_potions.model;

import com.codecool.hogwarts_potions.entity.Ingredient;

public class IngredientModel {
    private long id;
    private String name;

    public IngredientModel(Ingredient ingredient) {
        this.id = ingredient.getId();
        this.name = ingredient.getName();
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

}
