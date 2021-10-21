package com.codecool.hogwarts_potions.repository;

import com.codecool.hogwarts_potions.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAll();

    Ingredient findById(long id);

    Ingredient findByName(String ingredientName);
}