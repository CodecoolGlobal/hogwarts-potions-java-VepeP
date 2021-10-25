package com.codecool.hogwarts_potions.service;

import com.codecool.hogwarts_potions.entity.*;
import com.codecool.hogwarts_potions.model.BrewPotionModel;
import com.codecool.hogwarts_potions.model.PotionModel;
import com.codecool.hogwarts_potions.repository.PotionRepository;
import com.codecool.hogwarts_potions.repository.RecipeRepository;
import com.codecool.hogwarts_potions.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PotionService {

    private final PotionRepository potionRepository;
    private final StudentRepository studentRepository;
    private final RecipeRepository recipeRepository;
    private final IngredientService ingredientService;

    @Autowired
    public PotionService(PotionRepository potionRepository, StudentRepository studentRepository,
                         IngredientService ingredientService, RecipeRepository recipeRepository) {
        this.potionRepository = potionRepository;
        this.studentRepository = studentRepository;
        this.ingredientService = ingredientService;
        this.recipeRepository = recipeRepository;
    }

    public List<PotionModel> getAllPotions() {
        List<PotionModel> potionModels = new ArrayList<>();
        List<Potion> potions = potionRepository.findAllByOrderByIdAsc();
        for (Potion potion : potions) {
            potionModels.add(new PotionModel(potion));
        }
        return potionModels;
    }

    public PotionModel getPotionById(long id) {
        Potion potion = potionRepository.findById(id);
        return new PotionModel(potion);
    }

    public void addNewPotion(BrewPotionModel brewPotionModel) {
        Potion potion;
        Student student;
        Set<Ingredient> ingredients;
        Set<Recipe> allRecipes;
        String potionName;
        Recipe recipe;

        potion = potionRepository.findById(brewPotionModel.getId());
        student = studentRepository.findById(brewPotionModel.getStudentId());
        ingredients = ingredientService.getIngredientsByNames(brewPotionModel.getIngredients());
        allRecipes = recipeRepository.findAllByOrderByIdAsc();

        if (potion == null) {
            potionName = brewPotionModel.getPotionName();
            potion = new Potion(potionName, student);
        }

        potion.setIngredients(ingredients);
        potion.checkBrewingStatus(allRecipes);

        if (potion.getBrewingStatus() == BrewingStatus.DISCOVERY) {
            String recipeName = student.getName() + "'s discovery";
            recipe = new Recipe(recipeName, student, ingredients);
            potion.setRecipe(recipe);
            recipeRepository.save(recipe);
        }

        potionRepository.save(potion);
    }
}
