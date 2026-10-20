package org.parking_lot.factory;

import org.parking_lot.enums.PaymentMode;
import org.parking_lot.strategy.payment.CardPayment;
import org.parking_lot.strategy.payment.CashPayment;
import org.parking_lot.strategy.payment.PaymentStrategy;
import org.parking_lot.strategy.payment.UpiPayment;

public class PaymentStrategyFactory {
    static public PaymentStrategy get(PaymentMode mode) {
        if (mode == null) {
            throw new IllegalArgumentException("PaymentMode cannot be null");
        }

        switch (mode) {
            case CASH:
                return new CashPayment();
            case CARD:
                return new CardPayment();
            case UPI:
                return new UpiPayment();

            default:
                throw new IllegalArgumentException("Unsupported PaymentMode: " + mode);
        }
    }
}
