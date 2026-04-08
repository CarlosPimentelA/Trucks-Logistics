package com.trucks_logistics.Trucks.Logistics.trucks;

import java.util.List;

public interface ITruckService {

    TruckDTO addTruck(TruckDTO truckDto);

    List<TruckDTO> getTrucks();

    TruckDTO getTruckById(Long id);

    TruckDTO updateTruck(Long id, TruckUpdateDTO truckUpdateDTO);

    void deleteTruck(Long id);

    List<TruckDTO> getAvailableTrucks();

    void updateTruckAvailability(Long id, TruckStatus status);
}
