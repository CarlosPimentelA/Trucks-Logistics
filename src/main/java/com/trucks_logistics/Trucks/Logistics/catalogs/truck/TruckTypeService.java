package com.trucks_logistics.Trucks.Logistics.catalogs.truck;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TruckTypeService implements ITruckType {

    @Autowired
    TruckTypeRepository truckTypeRepository;

    @Override
    public TruckTypeDTO addTruckType(TruckTypeDTO truckTypeDTO) {
        TruckType trucktype = TruckMapper.toEntity(truckTypeDTO);
        truckTypeRepository.save(trucktype);
        return TruckMapper.toDTO(trucktype);
    }

    @Override
    public List<TruckTypeDTO> getTruckTypes() {
        return truckTypeRepository.findAll().stream().map(t -> TruckMapper.toDTO(t)).toList();
    }

}
