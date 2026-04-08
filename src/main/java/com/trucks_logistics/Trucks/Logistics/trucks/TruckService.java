package com.trucks_logistics.Trucks.Logistics.trucks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TruckService implements ITruckService {

    @Autowired
    TruckRepository truckRepository;

    @Autowired
    TruckMapper mapper;

    @Override
    public TruckDTO addTruck(TruckDTO truckDto) {
        Truck truck = mapper.truckDTOToTruck(truckDto);
        truckRepository.save(truck);
        return mapper.truckToTruckDTO(truck);
    }

    @Override
    public List<TruckDTO> getTrucks() {
        return mapper.ListTruckToTruckDTOs(truckRepository.findAll());
    }

    @Override
    public TruckDTO getTruckById(Long id) {
        return mapper.truckToTruckDTO(
                truckRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Camion no encontrado")));
    }

    @Override
    @Transactional
    public TruckDTO updateTruck(Long id, TruckUpdateDTO truckUpdateDTO) {
        Truck truckUpdate = truckRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Camion no encontrado"));

        if (truckUpdateDTO.getLicensePlate() != null
                && !truckUpdateDTO.getLicensePlate().equals(truckUpdate.getLicensePlate())) {
            if (truckRepository.existsByLicensePlate(truckUpdateDTO.getLicensePlate())) {
                throw new IllegalArgumentException("La placa ya esta registrada en otro camion");
            }
            // TODO: Tener la placa inmutable, crear un metodo que modifique la placa
            // exclusivamente con todas las verificaciones posibles.
            truckUpdate.setLicensePlate(truckUpdateDTO.getLicensePlate());
        }

        if (truckUpdateDTO.getTruckStatus() != null) {
            truckUpdate.setTruckStatus(truckUpdateDTO.getTruckStatus());
        }

        if (truckUpdateDTO.getTruckType() != null) {
            truckUpdate.setTruckType(truckUpdateDTO.getTruckType());
        }

        truckRepository.save(truckUpdate);
        return mapper.truckToTruckDTO(truckUpdate);
    }

    @Override
    public void deleteTruck(Long id) {
        if (!truckRepository.existsById(id)) {
            throw new EntityNotFoundException("No se puede eliminar: Camion no encontrado");
        }
        truckRepository.deleteById(id);
    }

    @Override
    public List<TruckDTO> getAvailableTrucks() {
        return mapper.ListTruckToTruckDTOs(truckRepository.findByTruckStatus(TruckStatus.LIBRE));
    }

    @Override
    public void updateTruckAvailability(Long id, TruckStatus status) {
        Truck truck = truckRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Camion no encontrado"));
        truck.setTruckStatus(status);
    }

}
