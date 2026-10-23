package org.parking_lot.factory;

import org.parking_lot.enums.PricingStrategyType;
import org.parking_lot.strategy.pricing.EventBasedPricing;
import org.parking_lot.strategy.pricing.PricingStrategy;
import org.parking_lot.strategy.pricing.TimeBasedPricing;

public class PricingStrategyFactory {
    static public PricingStrategy get(PricingStrategyType type) {
        if (type == null) {
            throw new IllegalArgumentException("PricingStrategy type cannot be null");
        }

        switch (type) {
            case TIME_BASED:
                return new TimeBasedPricing();
            case EVENT_BASED:
                return new EventBasedPricing();

            default:
                throw new IllegalArgumentException("Unsupported PricingStrategy type: " + type);
        }
    }
}
