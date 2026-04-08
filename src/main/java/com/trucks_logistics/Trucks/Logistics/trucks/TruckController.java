package com.trucks_logistics.Trucks.Logistics.trucks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/trucks")
public class TruckController {

    @Autowired
    TruckService truckService;

    @GetMapping
    public ResponseEntity<List<TruckDTO>> getTrucks() {
        return ResponseEntity.ok(truckService.getTrucks());
    }

    @GetMapping("/available")
    public ResponseEntity<List<TruckDTO>> getAvailableTrucks() {
        return ResponseEntity.ok(truckService.getAvailableTrucks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TruckDTO> getTruckById(@PathVariable Long id) {
        return ResponseEntity.ok(truckService.getTruckById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTruckById(@PathVariable Long id) {
        truckService.deleteTruck(id);
        return ResponseEntity.ok("Camion eliminado exitosamente");
    }

    @PostMapping
    public ResponseEntity<String> addTruck(@Valid @RequestBody TruckDTO truckDto) {
        truckService.addTruck(truckDto);
        return ResponseEntity.ok("Camion agregado exitosamente");
    }

    @PutMapping("/{id}/{disponibility}")
    public ResponseEntity<String> updateTruck(@Valid @RequestBody TruckUpdateDTO truckUpdateDTO, @PathVariable Long id,
            @PathVariable TruckStatus status) {
        truckService.updateTruck(id, truckUpdateDTO);
        return ResponseEntity.ok("Camion actualizado exitosamente");
    }

    @PatchMapping("/available/{id}/{disponibility}")
    public ResponseEntity<String> updateTruckAvailability(@PathVariable Long id,
            @PathVariable TruckStatus status) {
        truckService.updateTruckAvailability(id, status);
        return ResponseEntity.ok("Estado actualizado exitosamente");
    }

}
