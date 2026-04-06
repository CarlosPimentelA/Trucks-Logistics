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
    @Autowired
    private DriverMapper mapper;

    @Override
    public List<DriverDTO> getDrivers() {
        return mapper.ListDriverToDTOs(driverRepository.findAll());
    }

    @Override
    public DriverDTO getDriverById(Long id) {
        return mapper.driverToDriverDTO(driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conductor no encontrado")));
    }

    @Override
    public void addDrivers(DriverDTO driverDTO) {
        Driver driver = mapper.driverDTOToDriver(driverDTO);
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
    public DriverDTO updateDriver(DriverDTO driverDTO, Long id, DriverDisponibility disponibility) {
        Driver driverUpdate = driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conductor no encontrado"));

        driverUpdate.setFirstName(driverDTO.getFirstName());
        driverUpdate.setLastName(driverDTO.getLastName());
        driverUpdate.setLicenseType(driverDTO.getLicenseType());
        driverUpdate.setDriverDisponibility(disponibility);
        return mapper.driverToDriverDTO(driverUpdate);
    }

    @Override
    public List<DriverDTO> getAvailableDrivers() {
        return mapper.ListDriverToDTOs(driverRepository.findByDriverDisponibility(DriverDisponibility.DISPONIBLE));
    }

    @Override
    public void updateDriverAvailability(Long id, DriverDisponibility disponibility) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conductor no encontrado"));
        driver.setDriverDisponibility(disponibility);
    }
}
