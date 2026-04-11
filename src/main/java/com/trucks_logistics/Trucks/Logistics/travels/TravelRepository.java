package com.trucks_logistics.Trucks.Logistics.travels;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trucks_logistics.Trucks.Logistics.drivers.Driver;
import com.trucks_logistics.Trucks.Logistics.trucks.Truck;

public interface TravelRepository extends JpaRepository<Travel, Long> {

    List<Travel> findByDriver(Driver driver);

    List<Travel> findByTruck(Truck truck);
}
