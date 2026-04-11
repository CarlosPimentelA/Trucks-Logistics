package com.trucks_logistics.Trucks.Logistics.travels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelStatusUpdateRequest {
    private TravelStatus travelStatus;
}