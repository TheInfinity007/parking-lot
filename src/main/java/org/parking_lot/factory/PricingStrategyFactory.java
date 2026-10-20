package org.parking_lot.factory;

import org.parking_lot.enums.PricingStrategyType;
import org.parking_lot.service.EventBasePricing;
import org.parking_lot.service.PricingStrategy;
import org.parking_lot.service.TimeBasedPricing;

public class PricingStrategyFactory {
    PricingStrategy get(PricingStrategyType type) {
        if (type == null) {
            throw new IllegalArgumentException("PricingStrategy type cannot be null");
        }

        switch (type) {
            case TIME_BASED:
                return new TimeBasedPricing();
            case EVENT_BASED:
                return new EventBasePricing();

            default:
                throw new IllegalArgumentException("Unsupported PricingStrategy type: " + type);
        }
    }
}
