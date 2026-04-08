package com.trucks_logistics.Trucks.Logistics.trucks;

import com.trucks_logistics.Trucks.Logistics.catalogs.truck.TruckType;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TruckUpdateDTO {
    private TruckStatus truckStatus;
    @Size(min = 6, max = 10, message = "La placa debe tener entre 6 y 10 caracteres")
    private String licensePlate;
    private TruckType truckType;
}
