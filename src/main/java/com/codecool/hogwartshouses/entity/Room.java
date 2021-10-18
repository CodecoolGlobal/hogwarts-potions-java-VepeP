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
    @GeneratedValue
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @ApiModelProperty(notes = "Whether the room needs renovation")
    private boolean needsRenovation;

}
