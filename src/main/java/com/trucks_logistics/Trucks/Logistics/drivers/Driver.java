package com.trucks_logistics.Trucks.Logistics.drivers;

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
@NoArgsConstructor
@AllArgsConstructor
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String firstName;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Column(unique = true, nullable = false, length = 13)
    private String DNI;

    @Column(nullable = false, length = 15)
    private LicenseType licenseType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private DriverDisponibility driverDisponibility;
}