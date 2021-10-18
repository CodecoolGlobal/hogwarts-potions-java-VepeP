package com.codecool.hogwartshouses.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;

@ApiModel(description = "Details about a student")
@Entity
@Table(name = "student")
public class Student {
    @ApiModelProperty(notes = "The unique id of the student")
    @Id
    @GeneratedValue
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @ApiModelProperty(notes = "The day when student was created")
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdDate;

    @ApiModelProperty(notes = "The name of the student")
    @NotNull
    private String name;

    @ApiModelProperty(notes = "The room id of the student")
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room roomId;

    @ApiModelProperty(notes = "Whether the student has a cat")
    private boolean hasCat;

    @ApiModelProperty(notes = "Whether the student has an owl")
    private boolean hasOwl;

}