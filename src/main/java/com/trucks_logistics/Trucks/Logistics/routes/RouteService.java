package com.trucks_logistics.Trucks.Logistics.routes;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class RouteService implements IRouteService {

    private final RouteRepository routeRepository;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public RouteResponse addRoute(RouteRequest request) {
        Route route = new Route();
        route.setDeparturePoint(request.getDeparturePoint());
        route.setDestination(request.getDestination());

        // Distance calculation
        double lat1 = request.getDeparturePoint().latitude();
        double lon1 = request.getDeparturePoint().longitude();

        double lat2 = request.getDestination().latitude();
        double lon2 = request.getDestination().longitude();

        route.setDistanceKm(LocationUtils.locationDistance(lat1, lon1, lat2, lon2));

        routeRepository.save(route);

        return RouteMapper.toDTO(route);
    }

    @Override
    public List<RouteResponse> getRoutes() {
        return routeRepository.findAll().stream().map(RouteMapper::toDTO).toList();
    }

    @Override
    public RouteResponse getRouteById(Long id) {
        return RouteMapper.toDTO(
                routeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ruta no encontrada")));
    }

    @Override
    public void deleteRouteById(Long id) {
        Route route = routeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Ruta no encontrada"));
        routeRepository.delete(route);
    }

    @Override
    @Transactional
    public RouteResponse updateRoute(Long id, RouteUpdateRequest request) {
        Route routeUpdate = routeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Ruta no encontrada"));

        if (request.getDeparturePoint() != null) {
            routeUpdate.setDeparturePoint(request.getDeparturePoint());
        }

        if (request.getDestination() != null) {
            routeUpdate.setDestination(request.getDestination());
        }

        if (request.getDistanceKm() != null) {
            double lat1 = request.getDeparturePoint().latitude();
            double lon1 = request.getDeparturePoint().longitude();

            double lat2 = request.getDestination().latitude();
            double lon2 = request.getDestination().longitude();
            routeUpdate.setDistanceKm(LocationUtils.locationDistance(lat1, lon1, lat2, lon2));
        }
        return RouteMapper.toDTO(routeUpdate);
    }
}
