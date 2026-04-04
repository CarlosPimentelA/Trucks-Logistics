package com.trucks_logistics.Trucks.Logistics.trucks;

import com.trucks_logistics.Trucks.Logistics.catalogs.TruckType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TruckDTO {
    private TruckStatus truckStatus;
    private String licensePlate;
    private TruckType truckType;
}
