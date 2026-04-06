package com.trucks_logistics.Trucks.Logistics.trucks;

import com.trucks_logistics.Trucks.Logistics.catalogs.TruckType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TruckDTO {
    private Long id;
    @NotNull(message = "El estado del camion es obligatorio")
    private TruckStatus truckStatus;
    @NotBlank(message = "La placa del vahiculo es obligatoria")
    @Size(min = 6, max = 10, message = "La placa debe tener entre 6 y 10 caracteres")
    private String licensePlate;
    @NotNull(message = "El tipo del camion es obligatorio")
    private TruckType truckType;
}
