package org.parking_lot.strategy.pricing;

import org.parking_lot.enums.VehicleType;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class TimeBasedPricing implements PricingStrategy {

    // Peak period hours (e.g., 8:00 to 17:00)
    private final LocalTime PEAK_START = LocalTime.of(8, 0);
    private final LocalTime PEAK_END = LocalTime.of(17, 0);

    private boolean isPeak(LocalTime time) {
        return time.isAfter(PEAK_START) && time.isBefore(PEAK_END);
    }

    @Override
    public double calculateFee(VehicleType type, LocalDateTime entryTime, LocalDateTime exitTime) {
        if (entryTime.isBefore(exitTime)) {
            throw new IllegalArgumentException("Exit time before entry time");
        }

        long durationInMinutes = Duration.between(entryTime, exitTime).toMinutes();
        // Round up, if customer park for 40 minutes, he needs to pay for 1 hours
        long totalHours = (long) Math.ceil(durationInMinutes / 60);

        // Count peak hours and non-peak hours by iterating hour by hour
        int peakHours = 0;
        int nonPeakHours = 0;

        LocalDateTime cursor = entryTime.truncatedTo(ChronoUnit.HOURS);

        // If entryTime has minutes, consider first hour partially occupied, count as 1 hour
        for (int i = 0; i < totalHours; i++) {
            LocalTime hourStart = cursor.toLocalTime();
            if (isPeak(hourStart)) {
                peakHours++;
            } else {
                nonPeakHours++;
            }
            cursor = cursor.plusHours(1);
        }

        double peakRate = switch(type){
            case CAR -> 30.0;
            case BIKE -> 15.0;
            case TRUCK -> 50;
        };

        double nonPeakRate = switch(type){
            case CAR -> 20.0;
            case BIKE -> 10.0;
            case TRUCK -> 30;
        };

        return peakHours * peakRate + nonPeakHours * nonPeakRate;
    }
}
