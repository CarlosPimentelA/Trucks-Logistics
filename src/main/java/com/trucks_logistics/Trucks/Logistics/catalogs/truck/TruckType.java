package com.trucks_logistics.Trucks.Logistics.catalogs.truck;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, unique = true)
    @Enumerated(EnumType.STRING)
    private TruckTypes category;

    @Column(nullable = false, length = 75)
    private String description;

    @Column(nullable = false, length = 12)
    private int capacityMax;

    @Column(nullable = false, length = 15)
    private float estimatedConsumption;
}
