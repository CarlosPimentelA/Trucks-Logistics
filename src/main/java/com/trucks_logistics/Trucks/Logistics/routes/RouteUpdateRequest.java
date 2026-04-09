package com.trucks_logistics.Trucks.Logistics.routes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteUpdateRequest {
    private String departurePoint;
    private String destination;
    private Double distanceKm;
}
