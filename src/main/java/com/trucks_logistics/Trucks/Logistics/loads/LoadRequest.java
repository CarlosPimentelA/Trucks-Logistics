package com.trucks_logistics.Trucks.Logistics.loads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoadRequest {

    @NotNull(message = "El ID del viaje es obligatorio")
    private Long travelId;

    @NotNull(message = "El tipo de carga es obligatorio")
    private LoadTypes loadType;

    @Positive(message = "El peso de la carga debe ser mayor a cero")
    private Double loadWeight;

    @NotBlank(message = "La descripción de la carga no puede estar vacía")
    @Size(min = 10, max = 500, message = "La descripción debe tener entre 10 y 500 caracteres")
    private String loadDescription;
}