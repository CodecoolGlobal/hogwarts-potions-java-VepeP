package com.codecool.hogwartshouses.entity;

import com.codecool.hogwartshouses.entity.types.HouseType;
import com.codecool.hogwartshouses.entity.types.PetType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;

@ApiModel(description = "Details about a student")
@Entity
@Table(name = "student")
public class Student {
    @ApiModelProperty(notes = "The unique id of the student")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ApiModelProperty(notes = "The day when student was created")
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdDate;

    @ApiModelProperty(notes = "The name of the student")
    @NotNull
    private String name;

    @ApiModelProperty(notes = "Pet type of the student")
    private PetType petType;

    @ApiModelProperty(notes = "House type of the student")
    private HouseType houseType;

    public Student() {    }

    public Student(String name, PetType petType, HouseType houseType) {
        this.name = name;
        this.petType = petType;
        this.houseType = houseType;
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
}