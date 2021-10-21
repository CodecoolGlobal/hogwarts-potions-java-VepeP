package com.codecool.hogwarts_potions.controller;

import com.codecool.hogwarts_potions.entity.Room;
import com.codecool.hogwarts_potions.entity.Student;
import com.codecool.hogwarts_potions.entity.types.HouseType;
import com.codecool.hogwarts_potions.entity.types.PetType;
import com.codecool.hogwarts_potions.model.NewRoomModel;
import com.codecool.hogwarts_potions.model.NewStudentModel;
import com.codecool.hogwarts_potions.model.RoomModel;
import com.codecool.hogwarts_potions.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public String getAllRooms(Model model) {
        List<RoomModel> rooms = roomService.getAllRooms();
        model.addAttribute("rooms", rooms);
        return "showRooms";
    }

    @GetMapping("/rooms/{id}")
    public String getRoomById(@PathVariable long id, Model model) {
        RoomModel room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        return "showRoom";
    }

    @GetMapping("/rooms/available")
    public String getAllAvailableRooms(Model model) {
        List<RoomModel> rooms = roomService.getAllAvailableRooms();
        model.addAttribute("rooms", rooms);
        return "showAvailableRooms";
    }

    @GetMapping("/rooms/rat-owner")
    public String getRoomsWithoutCatOrOwl(Model model) {
        List<RoomModel> rooms = roomService.getAllRoomsWithoutCatOrOwl();
        model.addAttribute("rooms", rooms);
        return "showAvailableRooms";
    }

    // https://stackoverflow.com/questions/24256051/delete-or-put-methods-in-thymeleaf
    @GetMapping("/rooms/delete/{id}")
    public String deleteRoomById(@PathVariable long id, Model model) {
        roomService.deleteRoomById(id);
        return getAllRooms(model);
    }

    // https://stackoverflow.com/questions/24256051/delete-or-put-methods-in-thymeleaf
    @GetMapping("/rooms/put/{id}")
    public String putRoomById(@PathVariable long id, Model model) {
        roomService.updateRoomById(id);
        return getRoomById(id, model);
    }

    @GetMapping("/rooms/add")
    public String addRoom(Model model) {
        model.addAttribute("newRoomModel", new NewRoomModel());
        return "addRoom";
    }

    @PostMapping("/rooms")
    public String insertRoom(@ModelAttribute NewRoomModel newRoomModel, Model model) {
        roomService.insertRoom(new Room(newRoomModel));
        return getAllRooms(model);
    }
}
