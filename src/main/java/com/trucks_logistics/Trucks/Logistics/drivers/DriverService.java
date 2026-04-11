package com.trucks_logistics.Trucks.Logistics.drivers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class DriverService implements IDriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<DriverDTO> getDrivers() {
        return DriverMapper.ListDriverToDTOs(driverRepository.findAll());
    }

    @Override
    public DriverDTO getDriverById(Long id) {
        return DriverMapper.driverToDriverDTO(driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conductor no encontrado")));
    }

    @Override
    public void addDrivers(DriverDTO driverDTO) {
        Driver driver = DriverMapper.driverDTOToDriver(driverDTO);
        driver.setDriverDisponibility(DriverDisponibility.DISPONIBLE);
        driverRepository.save(driver);
    }

    @Override
    public void deleteDriverById(Long id) {
        if (!driverRepository.existsById(id)) {
            throw new EntityNotFoundException("No se puede eliminar: Conductor no encontrado");
        }
        driverRepository.deleteById(id);
    }

    @Override
    @Transactional
    public DriverDTO updateDriver(DriverUpdateDTO driverUpdateDTO, Long id) {
        Driver driverUpdate = driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conductor no encontrado"));

        if (driverUpdateDTO.getDni() != null && !driverUpdateDTO.getDni().equals(driverUpdate.getDNI())) {

            if (driverRepository.existsByDNI(driverUpdateDTO.getDni())) {
                throw new IllegalArgumentException("El DNI ya esta registrado con otro conductor");
            }
            // TODO: Tener el DNI inmutable, crear un metodo que modifique el dni
            // exclusivamente con todas las verificaciones posibles.
            driverUpdate.setDNI(driverUpdateDTO.getDni());
        }

        if (driverUpdateDTO.getFirstName() != null) {
            driverUpdate.setFirstName(driverUpdateDTO.getFirstName());
        }

        if (driverUpdateDTO.getLastName() != null) {
            driverUpdate.setLastName(driverUpdateDTO.getLastName());
        }

        if (driverUpdateDTO.getLicenseType() != null) {
            driverUpdate.setLicenseType(driverUpdateDTO.getLicenseType());
        }

        if (driverUpdateDTO.getDriverDisponibility() != null) {
            driverUpdate.setDriverDisponibility(driverUpdateDTO.getDriverDisponibility());
        }

        driverRepository.save(driverUpdate);
        return DriverMapper.driverToDriverDTO(driverUpdate);
    }

    @Override
    public List<DriverDTO> getAvailableDrivers() {
        return DriverMapper
                .ListDriverToDTOs(driverRepository.findByDriverDisponibility(DriverDisponibility.DISPONIBLE));
    }

    @Override
    @Transactional
    public void updateDriverAvailability(Long id, DriverDisponibility disponibility) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conductor no encontrado"));
        driver.setDriverDisponibility(disponibility);
        driverRepository.save(driver);
    }
}
