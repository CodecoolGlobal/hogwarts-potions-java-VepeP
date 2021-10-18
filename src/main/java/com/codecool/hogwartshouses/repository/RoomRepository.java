package com.codecool.hogwartshouses.repository;

import com.codecool.hogwartshouses.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findAll();

    Room findById(long id);

}
