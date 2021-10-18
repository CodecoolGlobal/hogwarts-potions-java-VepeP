package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.entity.Student;
import com.codecool.hogwartshouses.entity.types.HouseType;
import com.codecool.hogwartshouses.entity.types.PetType;
import com.codecool.hogwartshouses.model.StudentModel;
import com.codecool.hogwartshouses.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String getAllRooms(Model model) {
        List<StudentModel> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "showStudents";
    }

    @GetMapping("/students/{id}")
    public String getStudentById(@PathVariable long id, Model model) {
        StudentModel student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "showStudent";
    }

    @GetMapping("/students/add")
    public String addStudent() {
        return "addStudent";
    }

    @PostMapping("/student/add")
    public String insertStudent() {
        studentService.insertStudent(new Student("Test Elek", PetType.NONE, HouseType.GRYFFINDOR));
        return "index";
    }
}
