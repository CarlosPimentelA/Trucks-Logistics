package com.trucks_logistics.Trucks.Logistics.loads;

import com.trucks_logistics.Trucks.Logistics.travels.Travel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoadResponse {
    private Travel travel;

    private LoadTypes loadType;

    private double loadWeight;

    private String loadDescription;
}
