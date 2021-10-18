package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.entity.Room;
import com.codecool.hogwartshouses.entity.Student;
import com.codecool.hogwartshouses.entity.types.HouseType;
import com.codecool.hogwartshouses.entity.types.PetType;

public class StudentModel {
    private long id;
    private String name;
    private PetType petType;
    private HouseType houseType;
    private long roomId;

    public StudentModel(Student student, Room room) {
        this.id = student.getId();
        this.name = student.getName();
        this.petType = student.getPetType();
        this.houseType = student.getHouseType();

        if (room != null) this.roomId = room.getId();
        else roomId = -1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", petType=" + petType +
                ", houseType=" + houseType +
                ", roomId=" + roomId +
                '}';
    }
}
