package com.codecool.hogwartshouses.repository;

import com.codecool.hogwartshouses.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
