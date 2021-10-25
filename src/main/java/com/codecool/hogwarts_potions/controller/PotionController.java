package com.codecool.hogwarts_potions.controller;

import com.codecool.hogwarts_potions.entity.Ingredient;
import com.codecool.hogwarts_potions.model.*;
import com.codecool.hogwarts_potions.model.BrewingStatus;
import com.codecool.hogwarts_potions.service.IngredientService;
import com.codecool.hogwarts_potions.service.PotionService;
import com.codecool.hogwarts_potions.service.StudentService;
import com.codecool.hogwarts_potions.service.constants.BrewingServiceConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class PotionController {

    private final PotionService potionService;
    private final StudentService studentService;
    private final IngredientService ingredientService;

    @Autowired
    public PotionController(PotionService potionService, StudentService studentService, IngredientService ingredientService) {
        this.potionService = potionService;
        this.studentService = studentService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/potions")
    public String getAllPotions(Model model) {
        List<PotionModel> potions = potionService.getAllPotions();
        model.addAttribute("potions", potions);
        return "showPotions";
    }

    @GetMapping("/potions/{id}")
    public String getPotionById(@PathVariable long id, Model model) {
        PotionModel potion = potionService.getPotionById(id);
        BrewingStatus brewStatus = BrewingStatus.BREW;
        model.addAttribute("potion", potion);
        model.addAttribute("brewStatus", brewStatus);
        return "showPotion";
    }

    @GetMapping("/potions/put/{id}")
    public void updatePotion(@PathVariable long id, Model model) {
//        PotionModel potion = potionService.getPotionById(id);
//        model.addAttribute("potion", potion);
//        return "showPotion";
        System.out.println("I'm gonna update this potion.");
    }

    @GetMapping("/potions/brew")
    public String brewPotions(Model model) {
        List<StudentModel> students = studentService.getAllStudents();
        String ingredients = ingredientService.getIngredientNames();
        Integer maxIngredients = BrewingServiceConstants.MAX_INGREDIENTS_FOR_POTIONS;
        model.addAttribute("students", students);
        model.addAttribute("brewPotionModel", new BrewPotionModel());
        model.addAttribute("maxIngredients", maxIngredients);
        model.addAttribute("ingredients", ingredients);
        return "brewPotions";
    }

    @PostMapping("/potions")
    public String addNewPotions(@ModelAttribute BrewPotionModel brewPotionModel, Model model) {
        potionService.addNewPotion(brewPotionModel);
        return getAllPotions(model);
    }
}
