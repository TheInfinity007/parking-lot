package org.parking_lot.service;

import org.parking_lot.model.Ticket;

public interface PaymentStrategy {
    boolean pay(Ticket ticket, int amount);
}
