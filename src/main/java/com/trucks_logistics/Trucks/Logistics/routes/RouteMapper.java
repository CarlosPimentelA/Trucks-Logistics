package com.trucks_logistics.Trucks.Logistics.routes;

public class RouteMapper {
    public static RouteResponse toDTO(Route route) {
        return new RouteResponse(
                route.getId(),
                route.getDeparturePoint(),
                route.getDestination(),
                route.getDistanceKm());
    }

    public static Route toEntity(RouteRequest request) {
        return new Route(
                null,
                request.getDeparturePoint(),
                request.getDestination(),
                request.getDistanceKm());
    }

}
