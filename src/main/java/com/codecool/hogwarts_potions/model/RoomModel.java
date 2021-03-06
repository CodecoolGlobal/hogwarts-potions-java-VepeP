package com.codecool.hogwarts_potions.model;

import com.codecool.hogwarts_potions.entity.Room;
import com.codecool.hogwarts_potions.entity.Student;

import java.util.List;

public class RoomModel {
    private long id;
    private boolean needsRenovation;
    private int capacity;
    private String resident;
    private int availableBedNum;

    public RoomModel(Room room) {
        this.id = room.getId();
        this.needsRenovation = room.isNeedsRenovation();
        this.capacity = room.getCapacity();

        List<Student> students = room.getStudent();

        setResidentAndAvailableBedNumValue(students);
    }

    private void setResidentAndAvailableBedNumValue(List<Student> students) {
        if (students == null) {
            this.resident = "";
            this.availableBedNum = capacity;
        } else {
            if (students.size() == 1)
                this.resident = students.get(0).getName();
            else if (students.size() > 1)
                this.resident = getStudentsName(students);
            this.availableBedNum = capacity - students.size();
        }
    }

    private String getStudentsName(List<Student> students) {
        StringBuilder names = new StringBuilder();
        for (Student student : students) {
            names.append(student.getName()).append(", ");
        }
        return names.substring(0, names.length() - 2);
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAvailableBedNum() {
        return availableBedNum;
    }

    public void setAvailableBedNum(int availableBedNum) {
        this.availableBedNum = availableBedNum;
    }
}
