package com.codecool.hogwarts_potions.model;

import com.codecool.hogwarts_potions.entity.types.HouseType;
import com.codecool.hogwarts_potions.entity.types.PetType;

public class NewStudentModel {
    private String name;
    private PetType petType;
    private HouseType houseType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public HouseType getHouseType() {
        return houseType;
    }

    public void setHouseType(HouseType houseType) {
        this.houseType = houseType;
    }

}
