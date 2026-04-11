package com.trucks_logistics.Trucks.Logistics.travels;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelUpdateRequest {
    private LocalDateTime arrivalDate;
    private Long truckId;
    private Long driverId;
    private Long routeId;
}