package org.parking_lot.service;

import org.parking_lot.model.Ticket;

public class CardPayment implements PaymentStrategy{
    @Override
    public boolean pay(Ticket ticket, int amount) {
        return false;
    }
}
