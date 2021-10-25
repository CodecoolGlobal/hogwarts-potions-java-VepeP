package com.codecool.hogwarts_potions.repository;

import com.codecool.hogwarts_potions.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Set<Recipe> findAllByOrderByIdAsc();

    Recipe findById(long id);

    Recipe findByName(String recipeName);

}