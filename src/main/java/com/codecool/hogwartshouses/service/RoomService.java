package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.entity.Room;
import com.codecool.hogwartshouses.entity.Student;
import com.codecool.hogwartshouses.model.RoomModel;
import com.codecool.hogwartshouses.repository.RoomRepository;
import com.codecool.hogwartshouses.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository, StudentRepository studentRepository) {
        this.roomRepository = roomRepository;
        this.studentRepository = studentRepository;
    }

    public List<RoomModel> getAllRooms() {
        List<RoomModel> roomModels = new ArrayList<>();
        List<Room> rooms = roomRepository.findAll();
        for (Room room : rooms) {
            roomModels.add(new RoomModel(room));
        }
        return roomModels;
    }
}
