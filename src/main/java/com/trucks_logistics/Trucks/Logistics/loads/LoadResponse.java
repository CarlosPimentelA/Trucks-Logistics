package com.trucks_logistics.Trucks.Logistics.loads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoadResponse {
    private Long id;
    private LoadTypes loadType;

    private double loadWeight;

    private String loadDescription;
}
