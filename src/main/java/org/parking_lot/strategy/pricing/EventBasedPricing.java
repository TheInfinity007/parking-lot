package org.parking_lot.strategy.pricing;

import org.parking_lot.enums.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.EnumMap;
import java.util.Map;

public class EventBasedPricing implements PricingStrategy {

    private static final Map<VehicleType, Double> EVENT_HOURLY_RATES = new EnumMap<>(Map.of(
                    VehicleType.BIKE, 30.0,
                    VehicleType.CAR, 50.0,
                    VehicleType.TRUCK, 70.0
            ));

    @Override
    public double calculateFee(VehicleType type, LocalDateTime entryTime, LocalDateTime exitTime) {
        long durationInMinutes = Duration.between(entryTime, exitTime).toMinutes();

        long hours = (long)Math.ceil(durationInMinutes / 60.0);
        double ratePerHour = EVENT_HOURLY_RATES.get(type);
        return ratePerHour * hours;
    }
}
