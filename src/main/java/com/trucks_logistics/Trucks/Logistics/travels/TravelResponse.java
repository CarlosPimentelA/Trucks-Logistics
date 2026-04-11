package com.trucks_logistics.Trucks.Logistics.travels;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.trucks_logistics.Trucks.Logistics.drivers.DriverDTO;
import com.trucks_logistics.Trucks.Logistics.loads.LoadResponse;
import com.trucks_logistics.Trucks.Logistics.routes.RouteResponse;
import com.trucks_logistics.Trucks.Logistics.trucks.TruckResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TravelResponse {
    private Long id;

    private LocalDateTime departureDate;

    private LocalDateTime arriveDate;

    private String travelStatus;

    private Double estimatedUsedFuel;

    private BigDecimal currentFuelPrice;

    private BigDecimal estimatedTotalCost;

    private TruckResponse truck;

    private DriverDTO driver;

    private RouteResponse route;

    private List<LoadResponse> loads;
}
