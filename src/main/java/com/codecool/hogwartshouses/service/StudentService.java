package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.entity.Student;
import com.codecool.hogwartshouses.model.StudentModel;
import com.codecool.hogwartshouses.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentModel> getAllStudents() {
        List<StudentModel> studentModels = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            studentModels.add(new StudentModel(student));
        }
        return studentModels;
    }

    public void insertStudent(Student student) {
        studentRepository.save(student);
    }

    public StudentModel getStudentById(long id) {
        Student student = studentRepository.findById(id);
        return new StudentModel(student);
    }
}
