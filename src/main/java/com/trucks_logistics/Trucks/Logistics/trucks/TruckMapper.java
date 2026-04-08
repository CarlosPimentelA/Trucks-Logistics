package com.trucks_logistics.Trucks.Logistics.trucks;

import java.util.List;

import org.springframework.stereotype.Component;

import com.trucks_logistics.Trucks.Logistics.catalogs.truck.TruckType;

@Component
public class TruckMapper {

    public TruckResponse toDTO(Truck truck) {
        return new TruckResponse(truck.getId(), truck.getTruckStatus(), truck.getLicensePlate(), truck.getTruckType());
    }

    public Truck toEntity(TruckRequest request, TruckType truckType) {
        return new Truck(
                null,
                request.getTruckStatus(),
                request.getLicensePlate(),
                truckType);
    }

    public List<TruckResponse> ListTruckToTruckDTOs(List<Truck> trucks) {
        return trucks.stream().map(t -> this.toDTO(t)).toList();
    }
}