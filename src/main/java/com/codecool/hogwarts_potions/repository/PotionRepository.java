package com.codecool.hogwarts_potions.repository;

import com.codecool.hogwarts_potions.entity.Potion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PotionRepository extends JpaRepository<Potion, Long> {

    List<Potion> findAll();

    Potion findById(long id);

    List<Potion> findAllByOrderByIdAsc();
}
