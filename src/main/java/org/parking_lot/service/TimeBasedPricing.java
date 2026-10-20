package org.parking_lot.service;

import org.parking_lot.enums.VehicleType;

import java.time.LocalDateTime;

public class TimeBasedPricing implements PricingStrategy{

    @Override
    public double calculateFee(VehicleType type, LocalDateTime entryTime, LocalDateTime exitTime) {
        return 0;
    }
}
