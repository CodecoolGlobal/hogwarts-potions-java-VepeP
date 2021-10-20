package com.codecool.hogwarts_potions.controller;

import com.codecool.hogwarts_potions.model.PotionModel;
import com.codecool.hogwarts_potions.service.PotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PotionController {

    private final PotionService potionService;

    @Autowired
    public PotionController(PotionService potionService) {
        this.potionService = potionService;
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

}
