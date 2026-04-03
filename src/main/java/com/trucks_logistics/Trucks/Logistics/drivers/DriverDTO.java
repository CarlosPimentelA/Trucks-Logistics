package com.trucks_logistics.Trucks.Logistics.drivers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    private String firstName;
    private String lastName;
    private String DNI;
    private LicenseType licenseType;
}
