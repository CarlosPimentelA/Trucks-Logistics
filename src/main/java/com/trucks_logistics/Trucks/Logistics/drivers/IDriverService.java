package com.trucks_logistics.Trucks.Logistics.drivers;

import java.util.List;

public interface IDriverService {
    public List<DriverDTO> getDrivers();

    public DriverDTO getDriverById(Long id);

    public void addDrivers(DriverDTO driver);

    public void deleteDriverById(Long id);

    public DriverDTO updateDriver(DriverUpdateDTO driverUpdateDTO, Long id);

    public void updateDriverAvailability(Long id, DriverDisponibility disponibility);

    public List<DriverDTO> getAvailableDrivers();
}
