package com.example.wareQr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wareQr.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
