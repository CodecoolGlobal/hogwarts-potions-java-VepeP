package com.codecool.hogwarts_potions.entity;

import com.codecool.hogwarts_potions.entity.types.HouseType;
import com.codecool.hogwarts_potions.entity.types.PetType;
import com.codecool.hogwarts_potions.model.NewStudentModel;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdDate;

    @NotNull
    private String name;

    private PetType petType;

    private HouseType houseType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    public Student() {
    }

    public Student(String name, PetType petType, HouseType houseType) {
        this.name = name;
        this.petType = petType;
        this.houseType = houseType;
    }

    public Student(NewStudentModel newStudentModel) {
        this.name = newStudentModel.getName();
        this.petType = newStudentModel.getPetType();
        this.houseType = newStudentModel.getHouseType();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}