package com.codecool.hogwarts_potions.service;


import com.codecool.hogwarts_potions.entity.Ingredient;
import com.codecool.hogwarts_potions.repository.IngredientRepository;
import com.codecool.hogwarts_potions.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getIngredientsByNames(List<String> ingredientNames) {
        List<Ingredient> ingredientList = new ArrayList<>();
        Ingredient ingredient;
        for (String ingredientName : ingredientNames) {
            ingredient = ingredientRepository.findByName(ingredientName);
            if (ingredient == null)
                ingredient = new Ingredient(ingredientName);
            ingredientList.add(ingredient);
        }
        return ingredientList;
    }
}
