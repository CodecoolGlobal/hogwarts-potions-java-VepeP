package com.codecool.hogwarts_potions.repository;

import com.codecool.hogwarts_potions.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findAllByOrderByIdAsc();

    Room findById(long id);

}
