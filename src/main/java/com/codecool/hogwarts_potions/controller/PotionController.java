package com.codecool.hogwarts_potions.controller;

import com.codecool.hogwarts_potions.entity.Student;
import com.codecool.hogwarts_potions.model.AssignRoomModel;
import com.codecool.hogwarts_potions.model.IngredientModel;
import com.codecool.hogwarts_potions.model.PotionModel;
import com.codecool.hogwarts_potions.model.StudentModel;
import com.codecool.hogwarts_potions.service.PotionService;
import com.codecool.hogwarts_potions.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PotionController {

    private final PotionService potionService;
    private final StudentService studentService;

    @Autowired
    public PotionController(PotionService potionService, StudentService studentService) {
        this.potionService = potionService;
        this.studentService = studentService;
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
        model.addAttribute("potion", potion);
        return "showPotion";
    }

    @GetMapping("/potions/brew")
    public String brewPotions(Model model) {
        List<StudentModel> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        model.addAttribute("ingredientModel", new IngredientModel());
        return "brewPotions";
    }

    @PostMapping("/potions")
    public String addNewPotions(@ModelAttribute IngredientModel ingredientModel, Model model) {
        potionService.addNewPotion(ingredientModel);
        return getAllPotions(model);
    }
}
