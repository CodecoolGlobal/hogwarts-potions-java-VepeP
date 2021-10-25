package com.codecool.hogwarts_potions.repository;

import com.codecool.hogwarts_potions.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByOrderByIdAsc();

    Student findById(long id);
}
