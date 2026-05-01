package com.trucks_logistics.Trucks.Logistics.routes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteResponse {
    private Long id;
    private GeoLocation departurePoint;
    private GeoLocation destination;
    private double distanceKm;
}
