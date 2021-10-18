package com.codecool.hogwartshouses.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@ApiModel(description = "Details about a room")
@Entity
@Table(name = "room")
public class Room {
    @ApiModelProperty(notes = "The unique id of the student")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ApiModelProperty(notes = "Whether the room needs renovation")
    private boolean needsRenovation;

    @ApiModelProperty(notes = "The id of the resident")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    public Room() {

    }

    public Room(boolean needsRenovation) {
        this.needsRenovation = needsRenovation;
    }

    public Room(boolean needsRenovation, Student student) {
        this.needsRenovation = needsRenovation;
        this.student = student;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
