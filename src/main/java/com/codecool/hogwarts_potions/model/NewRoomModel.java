package com.codecool.hogwarts_potions.model;

import com.codecool.hogwarts_potions.entity.types.HouseType;
import com.codecool.hogwarts_potions.entity.types.PetType;

public class NewRoomModel {
    private boolean needRenovation;
    private int capacity;

    public boolean isNeedRenovation() {
        return needRenovation;
    }

    public void setNeedRenovation(boolean needRenovation) {
        this.needRenovation = needRenovation;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
