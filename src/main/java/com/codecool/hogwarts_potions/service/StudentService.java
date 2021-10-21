package com.codecool.hogwarts_potions.service;

import com.codecool.hogwarts_potions.entity.Room;
import com.codecool.hogwarts_potions.entity.Student;
import com.codecool.hogwarts_potions.model.AssignRoomModel;
import com.codecool.hogwarts_potions.model.StudentModel;
import com.codecool.hogwarts_potions.repository.RoomRepository;
import com.codecool.hogwarts_potions.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, RoomRepository roomRepository) {
        this.studentRepository = studentRepository;
        this.roomRepository = roomRepository;
    }

    public List<StudentModel> getAllStudents() {
        List<StudentModel> studentModels = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        Room room;
        for (Student student : students) {
            room = student.getRoom();
            studentModels.add(new StudentModel(student, room));
        }
        return studentModels;
    }

    public void insertStudent(Student student) {
        studentRepository.save(student);
    }

    public StudentModel getStudentById(long id) {
        Student student = studentRepository.findById(id);
        Room room = student.getRoom();
        return new StudentModel(student, room);
    }

    public void assignStudentToRoom(AssignRoomModel assignRoomModel) {
        Student student = studentRepository.findById(assignRoomModel.getStudentId());
        Room room = roomRepository.findById(assignRoomModel.getRoomId());
        room.addStudent(student);
        roomRepository.save(room);
    }
}
