package com.codecool.hogwarts_potions.service;

import com.codecool.hogwarts_potions.model.PotionModel;
import com.codecool.hogwarts_potions.repository.PotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PotionService {

    private final PotionRepository potionRepository;

    @Autowired
    public PotionService(PotionRepository potionRepository) {
        this.potionRepository = potionRepository;
    }
    public List<PotionModel> getAllPotions() {
        return null;
    }

    public PotionModel getPotionById(long id) {
        return null;
    }
}
