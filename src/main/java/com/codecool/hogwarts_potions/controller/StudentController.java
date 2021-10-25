package com.codecool.hogwarts_potions.controller;

import com.codecool.hogwarts_potions.entity.Student;
import com.codecool.hogwarts_potions.entity.types.HouseType;
import com.codecool.hogwarts_potions.entity.types.PetType;
import com.codecool.hogwarts_potions.model.AssignRoomModel;
import com.codecool.hogwarts_potions.model.NewStudentModel;
import com.codecool.hogwarts_potions.model.RoomModel;
import com.codecool.hogwarts_potions.model.StudentModel;
import com.codecool.hogwarts_potions.service.RoomService;
import com.codecool.hogwarts_potions.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;
    private final RoomService roomService;

    @Autowired
    public StudentController(StudentService studentService, RoomService roomService) {
        this.studentService = studentService;
        this.roomService = roomService;
    }

    @GetMapping("/students")
    public String getAllStudents(Model model) {
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
    public String addStudent(Model model) {
        HouseType[] houseTypes = HouseType.values();
        PetType[] petTypes = PetType.values();
        model.addAttribute("houseTypes", houseTypes);
        model.addAttribute("petTypes", petTypes);
        model.addAttribute("newStudentModel", new NewStudentModel());
        return "addStudent";
    }

    @GetMapping("/students/{id}/assignToRoom")
    public String assignStudentToRoomList(@PathVariable long id, Model model) {
        StudentModel student = studentService.getStudentById(id);
        List<RoomModel> rooms = roomService.getAllAvailableRooms();
        model.addAttribute("student", student);
        model.addAttribute("rooms", rooms);
        model.addAttribute("assignRoomModel", new AssignRoomModel());
        return "assignStudentToRoom";
    }

    @PostMapping("/students/{studentId}/assignToRoom")
    public String assignStudentToRoom(@ModelAttribute AssignRoomModel assignRoomModel, Model model) {
        studentService.assignStudentToRoom(assignRoomModel);
        return getAllStudents(model);
    }

    @PostMapping("/student/add")
    public String insertStudent(@ModelAttribute NewStudentModel newStudentModel, Model model) {
        studentService.insertStudent(new Student(newStudentModel));
        return getAllStudents(model);
    }
}
