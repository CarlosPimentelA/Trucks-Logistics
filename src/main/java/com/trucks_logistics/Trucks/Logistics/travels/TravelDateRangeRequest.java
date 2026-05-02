package com.trucks_logistics.Trucks.Logistics.travels;

import java.time.LocalDateTime;

public record TravelDateRangeRequest(LocalDateTime starDateTime, LocalDateTime endDateTime) {
}
