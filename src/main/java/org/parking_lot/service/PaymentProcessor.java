package org.parking_lot.service;

import org.parking_lot.model.Ticket;

public class PaymentProcessor {
    PaymentStrategy strategy;

    PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.strategy = paymentStrategy;
    }

    boolean pay(Ticket ticket, double amount) {
        return false;
    }
}
