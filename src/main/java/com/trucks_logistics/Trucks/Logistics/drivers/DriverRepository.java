package com.trucks_logistics.Trucks.Logistics.drivers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    List<Driver> findByDriverDisponibility(DriverDisponibility disponibility);
}
