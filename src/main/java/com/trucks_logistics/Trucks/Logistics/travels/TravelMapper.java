package com.trucks_logistics.Trucks.Logistics.travels;

import java.util.List;

import com.trucks_logistics.Trucks.Logistics.drivers.Driver;
import com.trucks_logistics.Trucks.Logistics.drivers.DriverMapper;
import com.trucks_logistics.Trucks.Logistics.loads.Load;
import com.trucks_logistics.Trucks.Logistics.loads.LoadMapper;
import com.trucks_logistics.Trucks.Logistics.routes.Route;
import com.trucks_logistics.Trucks.Logistics.routes.RouteMapper;
import com.trucks_logistics.Trucks.Logistics.trucks.Truck;
import com.trucks_logistics.Trucks.Logistics.trucks.TruckMapper;

public class TravelMapper {

    public static TravelResponse toDTO(Travel travel, List<Load> loads, Driver driver, Truck truck, Route route) {

        TravelResponse response = new TravelResponse(
                travel.getId(),
                travel.getDepartureDate(),
                travel.getArriveDate(),
                travel.getTravelStatus().toString(),
                travel.getEstimatedUsedFuel(),
                travel.getCurrentFuelPrice(),
                travel.getEstimatedTotalCost(),

                TruckMapper.toDTO(truck),
                DriverMapper.driverToDriverDTO(driver),
                RouteMapper.toDTO(route),
                travel.getLoads().stream().map(LoadMapper::toDTO).toList());

        return response;
    }

    public static Travel toEntity(TravelRequest request, Driver driver, Truck truck, Route route) {

        Travel travel = new Travel();
        // Atributos
        travel.setDepartureDate(request.getDepartureDate());
        travel.setTravelStatus(request.getTravelStatus());
        travel.setEstimatedUsedFuel(request.getEstimatedUsedFuel());
        travel.setCurrentFuelPrice(request.getCurrentFuelPrice());
        travel.setEstimatedTotalCost(request.getEstimatedTotalCost());

        // Entidades
        travel.setDriver(driver);
        travel.setRoute(route);
        travel.setTruck(truck);

        return travel;
    }
}
