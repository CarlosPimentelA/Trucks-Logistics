package com.trucks_logistics.Trucks.Logistics.catalogs.truck;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TruckTypeDTO {
    private Long id;

    @NotNull(message = "El tipo del camion es obligatorio")
    private TruckTypes truckCategory;

    @NotBlank(message = "La descripcion del camion es obligatoria")
    private String description;

    @NotNull(message = "La capacidad maxima del camion es obligatoria")
    private Integer capacityMax;

    @NotNull(message = "El consumo estimado del camion es obligatorio")
    private Float estimatedConsumption;
}
