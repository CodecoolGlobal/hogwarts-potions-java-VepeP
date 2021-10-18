package com.codecool.hogwartshouses.repository;

import com.codecool.hogwartshouses.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAll();

    Student findById(long id);
}
