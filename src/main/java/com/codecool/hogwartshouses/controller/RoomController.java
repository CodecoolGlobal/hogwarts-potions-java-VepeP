package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.entity.Room;
import com.codecool.hogwartshouses.model.RoomModel;
import com.codecool.hogwartshouses.service.RoomService;
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

    @PostMapping("/rooms")
    public String insertRoom() {
        roomService.insertRoom(new Room(false));
        return "index";
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
}
