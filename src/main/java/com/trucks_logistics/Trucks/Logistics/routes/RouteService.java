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
        return RouteMapper.toDTO(routeRepository.save(RouteMapper.toEntity(request)));
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
            routeUpdate.setDistanceKm(request.getDistanceKm());
        }
        return RouteMapper.toDTO(routeUpdate);
    }
}
