package com.trucks_logistics.Trucks.Logistics.trucks;

import java.util.List;

import com.trucks_logistics.Trucks.Logistics.catalogs.truck.TruckType;

public class TruckMapper {

    public static TruckResponse toDTO(Truck truck) {
        return new TruckResponse(truck.getId(), truck.getTruckStatus(), truck.getLicensePlate(), truck.getTruckType());
    }

    public static Truck toEntity(TruckRequest request, TruckType truckType) {
        return new Truck(
                null,
                request.getTruckStatus(),
                request.getLicensePlate(),
                truckType);
    }

    public static List<TruckResponse> ListTruckToTruckDTOs(List<Truck> trucks) {
        return trucks.stream().map(t -> toDTO(t)).toList();
    }
}