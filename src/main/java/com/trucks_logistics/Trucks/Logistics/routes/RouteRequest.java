package com.trucks_logistics.Trucks.Logistics.routes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteRequest {
    @NotBlank(message = "El punto de partida es obligatorio")
    @Size(min = 4, max = 50, message = "Rango de caracteres: 4-50")
    private String departurePoint;

    @NotBlank(message = "El destino es obligatorio")
    @Size(min = 4, max = 50, message = "Rango de caracteres: 4-50")
    private String destination;

    @NotNull(message = "La distancia recorrida estimada es obligatoria")
    @Positive(message = "La distancia debe de ser mayor a 0")
    private Double distanceKm;
}
