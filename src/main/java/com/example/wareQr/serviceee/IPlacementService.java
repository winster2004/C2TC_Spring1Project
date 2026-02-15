package com.example.wareQr.serviceee;

import java.util.List;

import com.example.wareQr.model.Placement;

public interface IPlacementService {

    Placement addPlacement(Placement placement);

    List<Placement> getAllPlacements();

    Placement getPlacementById(Long id);

    Placement updatePlacement(Long id, Placement placementDetails);

    void deletePlacement(Long id);
}
