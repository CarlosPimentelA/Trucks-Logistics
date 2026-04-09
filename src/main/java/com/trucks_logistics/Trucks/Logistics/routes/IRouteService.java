package com.trucks_logistics.Trucks.Logistics.routes;

import java.util.List;

public interface IRouteService {

    public List<RouteResponse> getRoutes();

    public RouteResponse getRouteById(Long id);

    public void deleteRouteById(Long id);

    public RouteResponse addRoute(RouteRequest request);

    public RouteResponse updateRoute(Long id, RouteUpdateRequest request);
}
