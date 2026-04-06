package com.trucks_logistics.Trucks.Logistics.drivers;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverUpdateDTO {
    @Size(min = 2, max = 15, message = "Debe contener entre 2 y 15 caracteres!")
    private String firstName;

    @Size(min = 3, max = 15, message = "Debe contener entre 3 y 15 caracteres!")
    private String lastName;

    @Size(min = 13, message = "Debe contener entre 13 caracteres!")
    private String dni;

    private LicenseType licenseType;

    private DriverDisponibility driverDisponibility;
}
