package com.codecool.hogwarts_potions.service;

import com.codecool.hogwarts_potions.entity.Ingredient;
import com.codecool.hogwarts_potions.entity.Potion;
import com.codecool.hogwarts_potions.entity.Recipe;
import com.codecool.hogwarts_potions.entity.Student;
import com.codecool.hogwarts_potions.model.IngredientModel;
import com.codecool.hogwarts_potions.model.PotionModel;
import com.codecool.hogwarts_potions.repository.PotionRepository;
import com.codecool.hogwarts_potions.repository.RecipeRepository;
import com.codecool.hogwarts_potions.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    public PotionModel getPotionById(long id) {
        return null;
    }

    public void addNewPotion(IngredientModel ingredientModel) {
        Student student = studentRepository.findById(ingredientModel.getStudentId());
        List<Ingredient> ingredients = ingredientService.getIngredientsByNames(ingredientModel.getIngredients());
        Potion potion = new Potion(student, ingredients);
        List<Recipe> allRecipes = recipeRepository.findAll();
        potion.checkBrewingStatus(allRecipes);
        //TODO
    }
}
