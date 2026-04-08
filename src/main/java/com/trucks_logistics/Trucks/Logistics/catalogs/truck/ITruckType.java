package com.trucks_logistics.Trucks.Logistics.catalogs.truck;

import java.util.List;

public interface ITruckType {
    public TruckTypeDTO addTruckType(TruckTypeDTO truckTypeDTO);

    public List<TruckTypeDTO> getTruckTypes();
}
