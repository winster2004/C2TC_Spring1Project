package com.example.wareQr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wareQr.model.College;

public interface CollegeRepository extends JpaRepository<College, Long> {
}