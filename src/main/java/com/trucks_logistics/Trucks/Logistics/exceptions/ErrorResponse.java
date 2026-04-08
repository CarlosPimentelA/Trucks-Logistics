package com.trucks_logistics.Trucks.Logistics.exceptions;

public record ErrorResponse(
        int status,
        String message,
        long timestamp) {

}