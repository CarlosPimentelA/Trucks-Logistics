package com.trucks_logistics.Trucks.Logistics.travels;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TravelRequest {
    @NotNull(message = "La fecha de salida es obligatoria")
    @FutureOrPresent(message = "La fecha de salida debe ser hoy o una fecha futura")
    private LocalDateTime departureDate;

    @NotNull(message = "El estado del viaje es obligatorio")
    private TravelStatus travelStatus;

    @NotNull(message = "El combustible estimado es obligatorio")
    @Positive(message = "El combustible estimado debe ser mayor a cero")
    private Double estimatedUsedFuel;

    @NotNull(message = "El precio actual del combustible es obligatorio")
    @Positive(message = "El precio del combustible debe ser un valor positivo")
    private BigDecimal currentFuelPrice;

    @NotNull(message = "El costo total estimado es obligatorio")
    @Positive(message = "El costo total estimado debe ser mayor a cero")
    private BigDecimal estimatedTotalCost;

    @NotNull(message = "El ID del camión es obligatorio")
    private Long truckId;

    @NotNull(message = "El ID del conductor es obligatorio")
    private Long driverId;

    @NotNull(message = "El ID de la ruta es obligatorio")
    private Long routeId;
}
