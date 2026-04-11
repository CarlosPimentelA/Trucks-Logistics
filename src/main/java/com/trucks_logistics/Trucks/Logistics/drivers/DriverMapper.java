package com.trucks_logistics.Trucks.Logistics.drivers;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DriverMapper {

    public static Driver driverDTOToDriver(DriverDTO driverDto) {
        Driver driver = new Driver();
        driver.setDNI(driverDto.getDni());
        driver.setFirstName(driverDto.getFirstName());
        driver.setLastName(driverDto.getLastName());
        driver.setLicenseType(driverDto.getLicenseType());
        return driver;
    }

    public static DriverDTO driverToDriverDTO(Driver driver) {
        DriverDTO driverDto = new DriverDTO(driver.getId(), driver.getFirstName(), driver.getLastName(),
                driver.getDNI(), driver.getLicenseType(), driver.getDriverDisponibility());
        return driverDto;
    }

    public static List<DriverDTO> ListDriverToDTOs(List<Driver> drivers) {
        return drivers.stream().map(d -> driverToDriverDTO(d)).toList();
    }
}
