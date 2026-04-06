package com.trucks_logistics.Trucks.Logistics.drivers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 15, message = "Debe contener entre 2 y 15 caracteres!")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 3, max = 15, message = "Debe contener entre 3 y 15 caracteres!")
    private String lastName;

    @NotBlank(message = "Su DNI es obligatorio")
    @Size(min = 13, message = "Debe contener entre 13 caracteres!")
    private String dni;

    @NotNull(message = "La categoria de su licencia es obligatoria")
    private LicenseType licenseType;
}
