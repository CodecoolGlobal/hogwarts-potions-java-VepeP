package com.codecool.hogwarts_potions.service;


import com.codecool.hogwarts_potions.entity.Ingredient;
import com.codecool.hogwarts_potions.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public Set<Ingredient> getIngredientsByNames(List<String> ingredientNames) {
        Set<Ingredient> ingredientList = new HashSet<>();
        Ingredient ingredient;
        for (String ingredientName : ingredientNames) {
            if (!ingredientName.equals("")) {
                ingredientName = ingredientName.toLowerCase();
                ingredient = ingredientRepository.findByName(ingredientName);
                if (ingredient == null)
                    ingredient = new Ingredient(ingredientName);
                ingredientList.add(ingredient);
            }
        }
        return ingredientList;
    }
}
