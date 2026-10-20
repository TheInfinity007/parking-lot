package org.parking_lot.strategy.payment;

import org.parking_lot.model.Ticket;

public class CardPayment implements PaymentStrategy {
    @Override
    public boolean pay(Ticket ticket, int amount) {
        return false;
    }
}
