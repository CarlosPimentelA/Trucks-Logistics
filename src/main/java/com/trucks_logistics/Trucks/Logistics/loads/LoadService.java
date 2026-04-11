package com.trucks_logistics.Trucks.Logistics.loads;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trucks_logistics.Trucks.Logistics.travels.Travel;
import com.trucks_logistics.Trucks.Logistics.travels.TravelRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class LoadService implements ILoadService {

    private final LoadRepository loadRepository;
    private final TravelRepository travelRepository;

    public LoadService(LoadRepository loadRepository, TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
        this.loadRepository = loadRepository;
    }

    @Override
    public LoadResponse createLoad(LoadRequest request) {
        Travel travel = travelRepository.findById(request.getTravelId()).orElseThrow(() -> new EntityNotFoundException(
                "No se puede crear la carga: El viaje con ID: " + request.getTravelId() + " no existe."));

        Load load = LoadMapper.toEntity(request, travel);

        // Sincronizar el lado del Travel
        travel.addLoad(load);
        return LoadMapper.toDTO(loadRepository.save(load));
    }

    @Override
    public List<LoadResponse> getAllLoads() {
        return loadRepository.findAll().stream().map(LoadMapper::toDTO).toList();
    }

    @Override
    public LoadResponse getLoadById(Long id) {
        return LoadMapper.toDTO(loadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("La carga con ID: " + id + " no existe.")));
    }

    @Override
    public LoadResponse updateLoad(Long id, LoadUpdateRequest request) {
        Load load = loadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("La carga con ID: " + id + " no existe."));
        // Solo actualizamos si el campo no es nulo
        if (request.getLoadType() != null) {
            load.setLoadType(request.getLoadType());
        }

        if (request.getLoadWeight() != null) {
            load.setLoadWeight(request.getLoadWeight());
        }

        if (request.getLoadDescription() != null) {
            load.setLoadDescription(request.getLoadDescription());
        }

        /* TODO: Hacer un metodo que permita cambiar el viaje si el usuario es admin */
        return LoadMapper.toDTO(loadRepository.save(load));
    }

    @Override
    public void deleteLoad(Long id) {
        Load load = loadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("La carga con ID: " + id + " no existe."));
        if (load.getTravel() != null) {
            load.getTravel().removeLoad(load);
        }
        loadRepository.delete(load);
    }

}
