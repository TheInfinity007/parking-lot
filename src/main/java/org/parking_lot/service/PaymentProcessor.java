package org.parking_lot.service;

import org.parking_lot.enums.PaymentStatus;
import org.parking_lot.model.Ticket;
import org.parking_lot.strategy.payment.PaymentStrategy;

public class PaymentProcessor {
    PaymentStrategy strategy;

    PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.strategy = paymentStrategy;
    }

    boolean pay(Ticket ticket, double amount) {
        boolean success = strategy.processPayment(ticket, amount);
        if (success) {
            ticket.setPaymentStatus(PaymentStatus.SUCCESS);
        } else {
            ticket.setPaymentStatus(PaymentStatus.PENDING);
            System.out.println("Payment failed for ticket: " + ticket.getTicketId());
        }

        return success;
    }
}
