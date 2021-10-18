package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.entity.Room;

public class RoomModel {
    private long id;
    private boolean needsRenovation;

    public RoomModel(Room room) {
        this.id = room.getId();
        this.needsRenovation = room.isNeedsRenovation();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isNeedsRenovation() {
        return needsRenovation;
    }

    public void setNeedsRenovation(boolean needsRenovation) {
        this.needsRenovation = needsRenovation;
    }
}
