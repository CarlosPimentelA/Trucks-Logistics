package com.trucks_logistics.Trucks.Logistics.travels;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.trucks_logistics.Trucks.Logistics.drivers.Driver;
import com.trucks_logistics.Trucks.Logistics.loads.Load;
import com.trucks_logistics.Trucks.Logistics.routes.Route;
import com.trucks_logistics.Trucks.Logistics.trucks.Truck;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime departureDate;

    private LocalDateTime arriveDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TravelStatus travelStatus;

    @Column(nullable = false)
    private Double estimatedUsedFuel;

    @Column(nullable = false)
    private BigDecimal currentFuelPrice;

    @Column(nullable = false)
    private BigDecimal estimatedTotalCost;

    @OneToMany(mappedBy = "travel", cascade = CascadeType.ALL)
    private List<Load> loads = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "truck_id", nullable = false)
    private Truck truck;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    public void addLoad(Load load) {
        loads.add(load);
        load.setTravel(this);
    }
}