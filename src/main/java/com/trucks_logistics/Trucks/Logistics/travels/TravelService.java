package com.trucks_logistics.Trucks.Logistics.travels;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.trucks_logistics.Trucks.Logistics.drivers.DriverRepository;
import com.trucks_logistics.Trucks.Logistics.drivers.Driver;
import com.trucks_logistics.Trucks.Logistics.routes.RouteRepository;
import com.trucks_logistics.Trucks.Logistics.trucks.Truck;
import com.trucks_logistics.Trucks.Logistics.trucks.TruckRepository;
import com.trucks_logistics.Trucks.Logistics.routes.Route;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TravelService implements ITravelService {

    private final TravelRepository travelRepository;
    private final TruckRepository truckRepository;
    private final DriverRepository driverRepository;
    private final RouteRepository routeRepository;

    public TravelService(TravelRepository travelRepository, TruckRepository truckRepository,
            DriverRepository driverRepository, RouteRepository routeRepository) {
        this.travelRepository = travelRepository;
        this.truckRepository = truckRepository;
        this.driverRepository = driverRepository;
        this.routeRepository = routeRepository;
    }

    // Empezamos mvp
    @Override
    public List<TravelResponse> findAll() {
        List<Travel> travels = travelRepository.findAll();
        return travels.stream()
                .map(t -> TravelMapper.toDTO(
                        t,
                        t.getLoads(),
                        t.getDriver(),
                        t.getTruck(),
                        t.getRoute()))
                .toList();
    }

    @Override
    public TravelResponse findById(Long id) {
        TravelDataBundle data = getEntities(id);

        return TravelMapper.toDTO(
                data.travel(),
                data.loads(),
                data.driver(),
                data.truck(),
                data.route());
    }

    @Override
    public TravelResponse create(TravelRequest request) {
        Driver driver = driverRepository.findById(request.getDriverId())
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado"));

        Truck truck = truckRepository.findById(request.getTruckId())
                .orElseThrow(() -> new RuntimeException("Camion no encontrado"));

        Route route = routeRepository.findById(request.getRouteId())
                .orElseThrow(() -> new RuntimeException("Ruta no encontrada"));

        Travel travel = TravelMapper.toEntity(request, driver, truck, route);

        // MVP rule: estado controlado por backend
        travel.setTravelStatus(TravelStatus.PENDIENTE);
        Travel saved = travelRepository.save(travel);

        TravelDataBundle data = getEntities(saved.getId());

        return TravelMapper.toDTO(
                data.travel(),
                data.loads(),
                data.driver(),
                data.truck(),
                data.route());
    }

    @Override
    public TravelResponse update(Long id, TravelUpdateRequest request) {
        Travel travel = travelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viaje no encontrado"));

        Driver driver = driverRepository.findById(request.getDriverId())
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado"));

        Truck truck = truckRepository.findById(request.getTruckId())
                .orElseThrow(() -> new RuntimeException("Camion no encontrado"));

        Route route = routeRepository.findById(request.getRouteId())
                .orElseThrow(() -> new RuntimeException("Ruta no encontrada"));

        travel.setDriver(driver);
        travel.setTruck(truck);
        travel.setRoute(route);
        travel.setArriveDate(request.getArrivalDate());

        Travel updated = travelRepository.save(travel);

        TravelDataBundle data = getEntities(updated.getId());

        return TravelMapper.toDTO(
                data.travel(),
                data.loads(),
                data.driver(),
                data.truck(),
                data.route());
    }

    @Override
    public void delete(Long id) {
        Travel travel = travelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viaje no encontrado"));
        travelRepository.delete(travel);
    }

    // Termina mvp

    // Empieza logica de negocio

    @Override
    public List<TravelResponse> findByDriver(Long driverId) {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado"));

        List<Travel> travels = travelRepository.findByDriver(driver);

        return travels.stream()
                .map(travel -> {
                    TravelDataBundle data = getEntities(travel.getId());

                    return TravelMapper.toDTO(
                            data.travel(),
                            data.loads(),
                            data.driver(),
                            data.truck(),
                            data.route());
                })
                .toList();
    }

    @Override
    public List<TravelResponse> findByTruck(Long truckId) {
        Truck truck = truckRepository.findById(truckId)
                .orElseThrow(() -> new RuntimeException("Camión no encontrado"));

        List<Travel> travels = travelRepository.findByTruck(truck);

        return travels.stream()
                .map(travel -> {
                    TravelDataBundle data = getEntities(travel.getId());

                    return TravelMapper.toDTO(
                            data.travel(),
                            data.loads(),
                            data.driver(),
                            data.truck(),
                            data.route());
                })
                .toList();
    }

    @Override
    public List<TravelResponse> findActiveTravels() {
        return null;
    }

    @Override
    public TravelResponse startTravel(Long id) {
        return null;
    }

    @Override
    public TravelResponse completeTravel(Long id, Double actualFuelUsed) {
        return null;
    }

    @Override
    public void cancelTravel(Long id, String reason) {
    }

    @Override
    public List<TravelResponse> findByDateRange(LocalDateTime start, LocalDateTime end) {
        return null;
    }

    @Override
    public boolean validateCapacity(Long travelId) {
        return false;
    }

    @Override
    public Double getCurrentTotalWeight(Long travelId) {
        return null;
    }

    @Override
    public TravelResponse refreshEstimatedCost(Long id) {
        return null;
    }

    private TravelDataBundle getEntities(Long id) {
        Travel travel = travelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Viaje no encontrado"));

        return new TravelDataBundle(
                travel,
                travel.getLoads(),
                travel.getDriver(),
                travel.getTruck(),
                travel.getRoute());
    }

}
