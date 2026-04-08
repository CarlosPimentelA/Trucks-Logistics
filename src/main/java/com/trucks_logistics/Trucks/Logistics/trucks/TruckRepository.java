package com.trucks_logistics.Trucks.Logistics.trucks;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TruckRepository extends JpaRepository<Truck, Long> {
    List<Truck> findByTruckStatus(TruckStatus status);

    boolean existsByLicensePlate(String licensePlate);
}
