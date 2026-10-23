package org.parking_lot.strategy.payment;

import org.parking_lot.model.Ticket;

public class CashPayment implements PaymentStrategy {
    @Override
    public boolean pay(Ticket ticket, int amount) {
        System.out.println("Paid Rs " + amount + " for ticket " + ticket.getTicketId() + " via Cash.");
        return true;
    }
}
