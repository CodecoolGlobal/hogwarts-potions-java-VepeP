package com.codecool.hogwarts_potions.entity;

import com.codecool.hogwarts_potions.model.NewRoomModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean needsRenovation;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "room")
    private List<Student> students;

    private int capacity;

    public Room() {
    }

    public Room(boolean needsRenovation, int capacity) {
        this.needsRenovation = needsRenovation;
        this.capacity = capacity;
    }

    public Room(NewRoomModel newRoomModel) {
        this.needsRenovation = newRoomModel.isNeedRenovation();
        this.capacity = newRoomModel.getCapacity();
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

    public List<Student> getStudent() {
        return students;
    }

    public void setStudent(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean hasEmptyBed(){
        int numOfStudents = students == null ? 0 : students.size();
        return numOfStudents < capacity;
    }
}
