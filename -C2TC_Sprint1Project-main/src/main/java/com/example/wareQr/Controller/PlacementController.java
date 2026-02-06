package com.example.wareQr.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wareQr.model.Placement;
import com.example.wareQr.serviceee.IPlacementService;

@RestController
@RequestMapping("/placements")
public class PlacementController {

    @Autowired
    private IPlacementService placementService;

    @PostMapping
    public Placement addPlacement(@RequestBody Placement placement) {
        return placementService.addPlacement(placement);
    }

    @GetMapping
    public List<Placement> getAllPlacements() {
        return placementService.getAllPlacements();
    }

    @GetMapping("/{id}")
    public Placement getPlacementById(@PathVariable Long id) {
        return placementService.getPlacementById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePlacement(@PathVariable Long id) {
        placementService.deletePlacement(id);
    }
}