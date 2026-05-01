package com.trucks_logistics.Trucks.Logistics.exceptions;

public class OverCapacityException extends RuntimeException {
    public OverCapacityException(String message) {
        super(message);
    }
}
