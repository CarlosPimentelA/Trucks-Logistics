package com.trucks_logistics.Trucks.Logistics.routes;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "origin_name")),
            @AttributeOverride(name = "latitude", column = @Column(name = "origin_lat")),
            @AttributeOverride(name = "longitude", column = @Column(name = "origin_lon"))
    })
    private GeoLocation departurePoint;

    @Column(nullable = false)
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "dest_name")),
            @AttributeOverride(name = "latitude", column = @Column(name = "dest_lat")),
            @AttributeOverride(name = "longitude", column = @Column(name = "dest_lon"))
    })
    private GeoLocation destination;

    @Column(nullable = false)
    @Positive(message = "La distancia debe de ser mayor a 0")
    private double distanceKm;
}
