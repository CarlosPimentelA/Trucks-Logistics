package com.trucks_logistics.Trucks.Logistics.catalogs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TruckType {
    @Id
    @GeneratedValue
    private int id;
    private String truckType;
    private String description;
    private int capacityMax;
    private float estimatedConsumption;
}
