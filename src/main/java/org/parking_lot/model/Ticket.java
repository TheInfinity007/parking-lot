package org.parking_lot.model;

import org.parking_lot.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Ticket {
    int id;
    LocalDateTime entryTime;
    String floorId;
    String spotId;
    Vehicle vehicle;
    PaymentStatus paymentStatus;
}
