package com.example.wareQr.services.impl;

import java.util.List;
import java.util.Optional;

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
        Optional<Placement> placement = placementRepository.findById(id);
        return placement.orElse(null);
    }

    // ✅ NEW METHOD - UPDATE PLACEMENT
    @Override
    public Placement updatePlacement(Long id, Placement placementDetails) {
        Optional<Placement> existingPlacementOpt = placementRepository.findById(id);
        
        if (existingPlacementOpt.isPresent()) {
            Placement existingPlacement = existingPlacementOpt.get();
            
            // Update all fields
            existingPlacement.setCompanyName(placementDetails.getCompanyName());
            existingPlacement.setJobRole(placementDetails.getJobRole());
            existingPlacement.setSalary(placementDetails.getSalary());
            existingPlacement.setPlacementDate(placementDetails.getPlacementDate());
            
            // Update relationships if provided
            if (placementDetails.getStudent() != null) {
                existingPlacement.setStudent(placementDetails.getStudent());
            }
            if (placementDetails.getCollege() != null) {
                existingPlacement.setCollege(placementDetails.getCollege());
            }
            
            return placementRepository.save(existingPlacement);
        }
        
        return null; // Placement not found
    }

    @Override
    public void deletePlacement(Long id) {
        placementRepository.deleteById(id);
    }
}