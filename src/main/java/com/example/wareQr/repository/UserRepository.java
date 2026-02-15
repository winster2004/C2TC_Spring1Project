package com.example.wareQr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wareQr.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}