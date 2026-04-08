package com.trucks_logistics.Trucks.Logistics.catalogs.truck;

public class TruckMapper {

    private TruckMapper() {
        throw new UnsupportedOperationException("Esta es una clase de utilidad y no debe ser instanciada");
    }

    public static TruckTypeDTO toDTO(TruckType truckType) {
        if (truckType == null) {
            return null;
        }
        return new TruckTypeDTO(
                truckType.getId(),
                truckType.getCategory(),
                truckType.getDescription(),
                truckType.getCapacityMax(),
                truckType.getEstimatedConsumption());
    }

    public static TruckType toEntity(TruckTypeDTO dto) {
        if (dto == null) {
            return null;
        }

        return new TruckType(
                dto.getId(),
                dto.getTruckCategory(),
                dto.getDescription(),
                dto.getCapacityMax(),
                dto.getEstimatedConsumption());
    }
}
