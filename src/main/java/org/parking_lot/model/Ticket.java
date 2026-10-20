package org.parking_lot.model;

import org.parking_lot.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Ticket {
    String ticketId;
    LocalDateTime entryTime;
    String floorId;
    String spotId;
    Vehicle vehicle;
    PaymentStatus paymentStatus;

    public Ticket(){
    }

    public Ticket(String id, LocalDateTime entryTime, Vehicle vehicle) {
        this.ticketId = id;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public String getTicketId() {
        return ticketId;
    }
}
