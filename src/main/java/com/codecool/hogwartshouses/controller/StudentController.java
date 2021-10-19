package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.entity.Room;
import com.codecool.hogwartshouses.entity.Student;
import com.codecool.hogwartshouses.entity.types.HouseType;
import com.codecool.hogwartshouses.entity.types.PetType;
import com.codecool.hogwartshouses.model.RoomModel;
import com.codecool.hogwartshouses.model.StudentModel;
import com.codecool.hogwartshouses.service.RoomService;
import com.codecool.hogwartshouses.service.StudentService;
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


    @GetMapping("/students/{id}/assignToRoom")
    public String assignStudentToRoomList(@PathVariable long id, Model model) {
        StudentModel student = studentService.getStudentById(id);
        List<RoomModel> rooms = roomService.getAllAvailableRooms();
        model.addAttribute("student", student);
        model.addAttribute("rooms", rooms);
        return "assignStudentToRoom";
    }

    @GetMapping("/students/{studentId}/assignStudentToRoom")
    public String assignStudentToRoom(@PathVariable long studentId, @RequestParam long roomId, Model model) {
        studentService.assignStudentToRoom(studentId, roomId);
        return getAllStudents(model);
    }

    @PostMapping("/students/{id}/assignStudentToRoom")
    public String assignStudentToRoomPost2(@PathVariable long id, @ModelAttribute Room room, Model model) {
        model.addAttribute("room", room);
        return getStudentById(id, model);
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
