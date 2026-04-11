package com.trucks_logistics.Trucks.Logistics.travels;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/travels")
@AllArgsConstructor
public class TravelController {
    private final TravelService travelService;

    // 📌 GET ALL
    @GetMapping
    public ResponseEntity<List<TravelResponse>> findAll() {
        return ResponseEntity.ok(travelService.findAll());
    }

    // 📌 GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<TravelResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(travelService.findById(id));
    }

    // 📌 CREATE
    @PostMapping
    public ResponseEntity<TravelResponse> create(@RequestBody TravelRequest request) {
        return ResponseEntity.ok(travelService.create(request));
    }

    // 📌 UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<TravelResponse> update(
            @PathVariable Long id,
            @RequestBody TravelUpdateRequest request) {
        return ResponseEntity.ok(travelService.update(id, request));
    }

    // 📌 DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        travelService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // 📌 FILTER BY DRIVER
    @GetMapping("/driver/{driverId}")
    public ResponseEntity<List<TravelResponse>> findByDriver(@PathVariable Long driverId) {
        return ResponseEntity.ok(travelService.findByDriver(driverId));
    }

    // 📌 FILTER BY TRUCK
    @GetMapping("/truck/{truckId}")
    public ResponseEntity<List<TravelResponse>> findByTruck(@PathVariable Long truckId) {
        return ResponseEntity.ok(travelService.findByTruck(truckId));
    }
}
