package com.codecool.hogwartshouses.controller;

import com.codecool.hogwartshouses.entity.Room;
import com.codecool.hogwartshouses.model.RoomModel;
import com.codecool.hogwartshouses.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @PostMapping("/rooms")
    public String insertRoom(){
        roomService.insertRoom(new Room(false));
        return "index";
    }
}
