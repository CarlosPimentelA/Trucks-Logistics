package com.trucks_logistics.Trucks.Logistics.trucks;

import java.util.List;

import org.springframework.stereotype.Service;

import com.trucks_logistics.Trucks.Logistics.catalogs.truck.TruckType;
import com.trucks_logistics.Trucks.Logistics.catalogs.truck.TruckTypeRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TruckService implements ITruckService {

    private final TruckRepository truckRepository;
    private final TruckTypeRepository truckTypeRepository;
    private final TruckMapper mapper;

    public TruckService(
            TruckRepository truckRepository,
            TruckTypeRepository truckTypeRepository,
            TruckMapper mapper) {
        this.truckRepository = truckRepository;
        this.truckTypeRepository = truckTypeRepository;
        this.mapper = mapper;
    }

    @Override
    public TruckResponse addTruck(TruckRequest request) {

        TruckType truckType = truckTypeRepository.findById(request.getTruckTypeId())
                .orElseThrow(() -> new EntityNotFoundException("Tipo de camion inexistente"));

        Truck truck = mapper.toEntity(request, truckType);

        truck = truckRepository.save(truck);

        return mapper.toDTO(truck);
    }

    @Override
    public List<TruckResponse> getTrucks() {
        return mapper.ListTruckToTruckDTOs(truckRepository.findAll());
    }

    @Override
    public TruckResponse getTruckById(Long id) {
        return mapper.toDTO(
                truckRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Camion no encontrado")));
    }

    @Override
    @Transactional
    public TruckResponse updateTruck(Long id, TruckUpdateRequest truckUpdateRequest) {
        Truck truckUpdate = truckRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Camion no encontrado"));

        if (truckUpdateRequest.getLicensePlate() != null
                && !truckUpdateRequest.getLicensePlate().equals(truckUpdate.getLicensePlate())) {
            if (truckRepository.existsByLicensePlate(truckUpdateRequest.getLicensePlate())) {
                throw new IllegalArgumentException("La placa ya esta registrada en otro camion");
            }
            // TODO: Tener la placa inmutable, crear un ENDPOINT que modifique la placa
            // exclusivamente con todas las verificaciones posibles.
            truckUpdate.setLicensePlate(truckUpdateRequest.getLicensePlate());
        }

        if (truckUpdateRequest.getTruckStatus() != null) {
            truckUpdate.setTruckStatus(truckUpdateRequest.getTruckStatus());
        }

        if (truckUpdateRequest.getTruckTypeId() != null) {
            TruckType truckType = truckTypeRepository.findById(truckUpdateRequest.getTruckTypeId())
                    .orElseThrow(() -> new EntityNotFoundException("Tipo de camion inexistente"));

            truckUpdate.setTruckType(truckType);
        }

        truckRepository.save(truckUpdate);
        return mapper.toDTO(truckUpdate);
    }

    @Override
    public void deleteTruck(Long id) {
        Truck truck = truckRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se puede eliminar: Camion no encontrado"));
        truckRepository.delete(truck);
    }

    @Override
    public List<TruckResponse> getAvailableTrucks() {
        return mapper.ListTruckToTruckDTOs(truckRepository.findByTruckStatus(TruckStatus.LIBRE));
    }

    @Override
    public List<TruckResponse> getInUseTrucks() {
        return mapper.ListTruckToTruckDTOs(truckRepository.findByTruckStatus(TruckStatus.EN_USO));
    }

    @Override
    public List<TruckResponse> getAssignedTrucks() {
        return mapper.ListTruckToTruckDTOs(truckRepository.findByTruckStatus(TruckStatus.ASIGNADO));
    }

    @Override
    public void updateTruckAvailability(Long id, TruckStatus status) {
        Truck truck = truckRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Camion no encontrado"));
        truck.setTruckStatus(status);
        truckRepository.save(truck);
    }

}
