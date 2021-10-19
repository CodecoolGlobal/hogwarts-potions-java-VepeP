package com.codecool.hogwartshouses.repository;

import com.codecool.hogwartshouses.entity.Room;
import com.codecool.hogwartshouses.entity.types.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findAllByOrderByIdAsc();

    List<Room> findAllByStudentNullOrderByIdAsc();

    Room findById(long id);

    Room findByStudentId(long id);

    List<Room> findAllByStudentNullOrStudentPetTypeNotInOrderByIdAsc(Collection<PetType> pets);

}
