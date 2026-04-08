package com.trucks_logistics.Trucks.Logistics.trucks;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TruckUpdateRequest {
    private TruckStatus truckStatus;
    @Size(min = 6, max = 10, message = "La placa debe tener entre 6 y 10 caracteres")
    private String licensePlate;
    private Long truckTypeId;
}
