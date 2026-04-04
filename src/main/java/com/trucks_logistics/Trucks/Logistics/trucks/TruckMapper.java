package com.trucks_logistics.Trucks.Logistics.trucks;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TruckMapper {

    public TruckDTO truckToTruckDTO(Truck truck) {
        TruckDTO truckDto = new TruckDTO(truck.getTruckStatus(), truck.getLicensePlate(), truck.getTruckType());
        return truckDto;
    }

    public Truck truckDTOToTruck(TruckDTO truckDto) {
        Truck truck = new Truck();
        truck.setLicensePlate(truckDto.getLicensePlate());
        truck.setTruckStatus(truckDto.getTruckStatus());
        truck.setTruckType(truckDto.getTruckType());
        return truck;
    }

    public List<TruckDTO> ListTruckDTOToTruck(List<Truck> trucks) {
        return trucks.stream().map(t -> this.truckToTruckDTO(t)).toList();
    }

    public List<TruckDTO> ListTruckToTruckDTOs(List<Truck> trucks) {
        return trucks.stream().map(t -> this.truckToTruckDTO(t)).toList();
    }
}