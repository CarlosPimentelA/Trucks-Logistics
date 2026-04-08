package com.trucks_logistics.Trucks.Logistics.trucks;

import java.util.List;

public interface ITruckService {

    TruckResponse addTruck(TruckRequest request);

    List<TruckResponse> getTrucks();

    TruckResponse getTruckById(Long id);

    TruckResponse updateTruck(Long id, TruckUpdateRequest truckUpdateRequest);

    void deleteTruck(Long id);

    List<TruckResponse> getAvailableTrucks();

    void updateTruckAvailability(Long id, TruckStatus status);

    public List<TruckResponse> getInUseTrucks();

    public List<TruckResponse> getAssignedTrucks();
}
