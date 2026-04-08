package com.trucks_logistics.Trucks.Logistics.trucks;

import com.trucks_logistics.Trucks.Logistics.catalogs.truck.TruckType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TruckStatus truckStatus = TruckStatus.LIBRE;

    @Column(unique = true, nullable = false, length = 10)
    private String licensePlate;

    @ManyToOne
    @JoinColumn(name = "truck_type_id", nullable = false)
    private TruckType truckType;

    @PrePersist
    @PreUpdate
    private void normalize() {
        if (truckStatus == null) {
            truckStatus = TruckStatus.LIBRE;
        }

        if (licensePlate != null) {
            licensePlate = licensePlate.trim().toUpperCase();
        }
    }
}