package com.trucks_logistics.Trucks.Logistics.travels;

import java.time.LocalDateTime;
import java.util.List;

public interface ITravelService {

    // --- CRUD BÁSICO ---
    List<TravelResponse> findAll();

    TravelResponse findById(Long id);

    TravelResponse create(TravelRequest request);

    TravelResponse update(Long id, TravelUpdateRequest request);

    void delete(Long id);

    // --- BÚSQUEDAS AVANZADAS (Filtros para el Operador) ---
    List<TravelResponse> findByDriver(Long driverId);

    List<TravelResponse> findByTruck(Long truckId);

    List<TravelResponse> findByDateRange(LocalDateTime start, LocalDateTime end);

    List<TravelResponse> findActiveTravels(); // Solo los que están IN_PROGRESS

    // --- GESTIÓN DE ESTADOS Y FLUJO LOGÍSTICO ---

    /** Inicia el viaje y valida que el camión no esté en otro viaje activo */
    void startTravelStatus(Long id);

    /**
     * Finaliza el viaje y calcula la diferencia entre combustible estimado y real
     */
    void completeTravelStatus(Long id);

    /** Cancela un viaje (solo si está PENDING) y libera al conductor y camión */
    void cancelTravelStatus(Long id);

    void loadingTravelStatus(Long id);

    void pendingTravelStatus(Long id);

    void unloadingTravelStatus(Long id);

    void stopTravelStatus(Long id);

    // --- GESTIÓN DE CARGA (Relación con Load) ---

    /** Obtiene el resumen de carga actual del viaje */
    Double getCurrentTotalWeight(Long travelId);

    // --- ANALÍTICA Y COSTOS ---

    /**
     * Recalcula el costo total si el precio del combustible cambió antes de salir
     */
    TravelResponse refreshEstimatedCost(Long id);
}
