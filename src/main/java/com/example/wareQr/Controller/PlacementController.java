package com.example.wareQr.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.wareQr.model.Placement;
import com.example.wareQr.serviceee.IPlacementService;

@RestController
@RequestMapping("/placements")
public class PlacementController {

    @Autowired
    private IPlacementService placementService;

    // CREATE
    @PostMapping
    public ResponseEntity<Placement> addPlacement(@RequestBody Placement placement) {
        try {
            Placement savedPlacement = placementService.addPlacement(placement);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedPlacement);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Placement>> getAllPlacements() {
        try {
            List<Placement> placements = placementService.getAllPlacements();
            if (placements.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(placements);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Placement> getPlacementById(@PathVariable Long id) {
        try {
            Placement placement = placementService.getPlacementById(id);
            if (placement != null) {
                return ResponseEntity.ok(placement);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Placement> updatePlacement(
            @PathVariable Long id,
            @RequestBody Placement placement) {
        try {
            Placement updatedPlacement = placementService.updatePlacement(id, placement);
            if (updatedPlacement != null) {
                return ResponseEntity.ok(updatedPlacement);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlacement(@PathVariable Long id) {
        try {
            placementService.deletePlacement(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
