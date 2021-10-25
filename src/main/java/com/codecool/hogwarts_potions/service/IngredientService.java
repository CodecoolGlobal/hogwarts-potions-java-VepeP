package com.codecool.hogwarts_potions.service;


import com.codecool.hogwarts_potions.entity.Ingredient;
import com.codecool.hogwarts_potions.model.IngredientModel;
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
                if (ingredient == null) {
                    ingredient = new Ingredient(ingredientName);
                    ingredientRepository.save(ingredient);
                }
                ingredientList.add(ingredient);
            }
        }
        return ingredientList;
    }

    public List<IngredientModel> getAllIngredients() {
        List<IngredientModel> ingredientModels = new ArrayList<>();
        List<Ingredient> ingredients = ingredientRepository.findAllByOrderByIdAsc();
        for (Ingredient ingredient : ingredients) {
            ingredientModels.add(new IngredientModel(ingredient));
        }
        return ingredientModels;
    }


    public String getIngredientNames(){
        List<Ingredient> ingredients = ingredientRepository.findAllByOrderByIdAsc();
        StringBuilder names = new StringBuilder();
        if (ingredients == null || ingredients.size() == 0)
            return "-";
        for (Ingredient ingredient : ingredients) {
            names.append(ingredient.getName()).append(", ");
        }
        return names.substring(0, names.length() - 2);
    }
}
