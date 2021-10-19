package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.entity.Room;
import com.codecool.hogwartshouses.entity.Student;
import com.codecool.hogwartshouses.model.StudentModel;
import com.codecool.hogwartshouses.repository.RoomRepository;
import com.codecool.hogwartshouses.repository.StudentRepository;
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
            room = roomRepository.findByStudentId(student.getId());
            studentModels.add(new StudentModel(student, room));
        }
        return studentModels;
    }

    public void insertStudent(Student student) {
        studentRepository.save(student);
    }

    public StudentModel getStudentById(long id) {
        Student student = studentRepository.findById(id);
        Room room = roomRepository.findByStudentId(id);
        return new StudentModel(student, room);
    }

    public void assignStudentToRoom(long studentId, long roomId) {
        Student student = studentRepository.findById(studentId);
        Room room = roomRepository.findById(roomId);
        room.setStudent(student);
        roomRepository.save(room);
    }
}
