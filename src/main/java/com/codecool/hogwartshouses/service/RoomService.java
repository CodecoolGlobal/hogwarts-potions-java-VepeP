package com.codecool.hogwartshouses.service;

import com.codecool.hogwartshouses.entity.Room;
import com.codecool.hogwartshouses.entity.types.PetType;
import com.codecool.hogwartshouses.model.RoomModel;
import com.codecool.hogwartshouses.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<RoomModel> getAllRooms() {
        List<RoomModel> roomModels = new ArrayList<>();
        List<Room> rooms = roomRepository.findAllByOrderByIdAsc();
        for (Room room : rooms) {
            roomModels.add(new RoomModel(room));
        }
        return roomModels;
    }

    public void insertRoom(Room room) {
        roomRepository.save(room);
    }

    public RoomModel getRoomById(long id) {
        Room room = roomRepository.findById(id);
        return new RoomModel(room);
    }

    public void deleteRoomById(long id) {
        roomRepository.deleteById(id);
    }

    public void updateRoomById(long id) {
        Room room = roomRepository.getById(id);
        room.setNeedsRenovation(false);
        roomRepository.save(room);
    }

    public List<RoomModel> getAllAvailableRooms() {
        List<RoomModel> roomModels = new ArrayList<>();
        List<Room> rooms = roomRepository.findAllByStudentNullOrderByIdAsc();
        for (Room room : rooms) {
            roomModels.add(new RoomModel(room));
        }
        return roomModels;
    }

    public List<RoomModel> getAllRoomsWithoutCatOrOwl() {
        List<RoomModel> roomModels = new ArrayList<>();
        List<PetType> forbiddenPets = List.of(PetType.CAT, PetType.OWL);
        List<Room> rooms = roomRepository.findAllByStudentNullOrStudentPetTypeNotInOrderByIdAsc(forbiddenPets);
        for (Room room : rooms) {
            roomModels.add(new RoomModel(room));
        }
        return roomModels;
    }
}
