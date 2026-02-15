package com.example.wareQr.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wareQr.model.Placement;
import com.example.wareQr.repository.PlacementRepository;
import com.example.wareQr.serviceee.IPlacementService;

@Service
public class PlacementServiceImpl implements IPlacementService {

    @Autowired
    private PlacementRepository placementRepository;

    @Override
    public Placement addPlacement(Placement placement) {
        return placementRepository.save(placement);
    }

    @Override
    public List<Placement> getAllPlacements() {
        return placementRepository.findAll();
    }

    @Override
    public Placement getPlacementById(Long id) {
        return placementRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePlacement(Long id) {
        placementRepository.deleteById(id);
    }
}