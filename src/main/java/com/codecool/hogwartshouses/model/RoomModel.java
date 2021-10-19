package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.entity.Room;
import com.codecool.hogwartshouses.entity.Student;

public class RoomModel {
    private long id;
    private boolean needsRenovation;
    private String resident;

    public RoomModel(Room room) {
        this.id = room.getId();
        this.needsRenovation = room.isNeedsRenovation();

        Student student = room.getStudent();

        if (student != null) this.resident = student.getName();
        else this.resident = "";
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

    public String getResident() {
        return resident;
    }

    public void setResident(String resident) {
        this.resident = resident;
    }
}
