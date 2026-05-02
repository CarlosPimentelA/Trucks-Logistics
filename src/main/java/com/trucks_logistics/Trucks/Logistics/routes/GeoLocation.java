package com.trucks_logistics.Trucks.Logistics.routes;

import jakarta.persistence.Embeddable;

@Embeddable
public record GeoLocation(
                String name,
                Double latitude,
                Double longitude) {
}
