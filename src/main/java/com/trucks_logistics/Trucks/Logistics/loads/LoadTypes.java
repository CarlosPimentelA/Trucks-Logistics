package com.trucks_logistics.Trucks.Logistics.loads;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public enum LoadTypes {
    GENERAL("Carga General", 1.0, false, 3),
    PERECEDERO_FRIO("Perecederos", 1.25, true, 1),
    PELIGROSA("Inflamables/Químicos", 1.50, false, 1),
    GRANEL_LIQUIDO("Líquidos a Granel", 1.10, false, 2),
    FRAGIL("Cristalería/Electrónica", 1.15, false, 2),
    MAQUINARIA("Equipos Pesados", 1.40, false, 3);

    private final String realName;
    private final double priceFactor;
    private final boolean refrigerationRequired;
    private final int priorityLevel;

    LoadTypes(String realName, double priceFactor, boolean refrigerationRequired, int priorityLevel) {
        this.realName = realName;
        this.priceFactor = priceFactor;
        this.refrigerationRequired = refrigerationRequired;
        this.priorityLevel = priorityLevel;
    }

    public BigDecimal calculateFinalPrice(BigDecimal tarifaBase) {
        return tarifaBase.multiply(BigDecimal.valueOf(this.priceFactor));
    }

    public String getSecurityProtocol() {
        return switch (this) {
            case PELIGROSA -> "EXTREMOS: Uso de extintores y prohibido fumar.";
            case PERECEDERO_FRIO -> "FRÍO: Mantener temperatura entre 0°C y 4°C.";
            case FRAGIL -> "MANEJO: No estibar más de 3 niveles.";
            default -> "ESTÁNDAR: Asegurar carga con correas.";
        };
    }
}
