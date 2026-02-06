package com.example.wareQr.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wareQr.model.Placement;

public interface PlacementRepository extends JpaRepository<Placement, Long> {
}