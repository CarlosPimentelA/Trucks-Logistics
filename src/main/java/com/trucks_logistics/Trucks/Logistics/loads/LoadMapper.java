package com.trucks_logistics.Trucks.Logistics.loads;

import com.trucks_logistics.Trucks.Logistics.travels.Travel;

public class LoadMapper {

    public static LoadResponse toDTO(Load load) {
        return new LoadResponse(
                load.getTravel(),
                load.getLoadType(),
                load.getLoadWeight(),
                load.getLoadDescription());
    }

    public static Load toEntity(LoadRequest request, Travel travel) {
        return new Load(
                null,
                travel,
                request.getLoadType(),
                request.getLoadWeight(),
                request.getLoadDescription());

    }
}
