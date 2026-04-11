package com.trucks_logistics.Trucks.Logistics.travels;

import java.util.List;

import com.trucks_logistics.Trucks.Logistics.drivers.Driver;
import com.trucks_logistics.Trucks.Logistics.loads.Load;
import com.trucks_logistics.Trucks.Logistics.routes.Route;
import com.trucks_logistics.Trucks.Logistics.trucks.Truck;

public record TravelDataBundle(
        Travel travel,
        List<Load> loads,
        Driver driver,
        Truck truck,
        Route route) {
}
