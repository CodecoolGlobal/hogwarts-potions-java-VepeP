package com.codecool.hogwartshouses.model;

import com.codecool.hogwartshouses.entity.Room;
import com.codecool.hogwartshouses.entity.Student;
import com.codecool.hogwartshouses.entity.types.HouseType;
import com.codecool.hogwartshouses.entity.types.PetType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentModel {
    private long id;
    private String name;
    private Room roomId;
    private PetType petType;
    private HouseType houseType;

    public StudentModel(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.roomId = student.getRoomId();
        this.petType = student.getPetType();
        this.houseType = student.getHouseType();
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

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
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
