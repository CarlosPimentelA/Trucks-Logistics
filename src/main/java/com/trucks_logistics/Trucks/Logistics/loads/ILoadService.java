package com.trucks_logistics.Trucks.Logistics.loads;

import java.util.List;

public interface ILoadService {

    LoadResponse createLoad(LoadRequest request);

    List<LoadResponse> getAllLoads();

    LoadResponse getLoadById(Long id);

    LoadResponse updateLoad(Long id, LoadUpdateRequest request);

    void deleteLoad(Long id);

}
