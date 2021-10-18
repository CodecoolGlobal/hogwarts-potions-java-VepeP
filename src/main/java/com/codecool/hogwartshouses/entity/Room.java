package com.codecool.hogwartshouses.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@ApiModel(description = "Details about a room")
@Entity
@Table(name = "room")
public class Room {
    @ApiModelProperty(notes = "The unique id of the student")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ApiModelProperty(notes = "Whether the room needs renovation")
    private boolean needsRenovation;

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
