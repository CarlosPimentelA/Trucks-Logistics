package com.trucks_logistics.Trucks.Logistics.loads;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoadUpdateRequest {
    private LoadTypes loadType;

    @Positive(message = "El peso de la carga debe ser mayor a cero")
    private Double loadWeight;

    @Size(min = 10, max = 500, message = "La descripción debe tener entre 10 y 500 caracteres")
    private String loadDescription;
}
