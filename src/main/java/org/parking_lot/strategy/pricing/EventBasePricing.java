package org.parking_lot.strategy.pricing;

import org.parking_lot.enums.VehicleType;

import java.time.LocalDateTime;

public class EventBasePricing implements PricingStrategy {
    @Override
    public double calculateFee(VehicleType type, LocalDateTime entryTime, LocalDateTime exitTime) {
        return 0;
    }
}
