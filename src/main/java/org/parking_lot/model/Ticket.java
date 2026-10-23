package org.parking_lot.model;

import org.parking_lot.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Ticket {
    private final String ticketId;
    private final LocalDateTime entryTime;
    private final String floorId;
    private final String spotId;
    private final Vehicle vehicle;
    private PaymentStatus paymentStatus;

    public Ticket(String ticketId, LocalDateTime entryTime, Vehicle vehicle, String floorId, String spotId) {
        this.ticketId = ticketId;
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.floorId = floorId;
        this.spotId = spotId;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getFloorId() {
        return floorId;
    }

    public String getSpotId() {
        return spotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public static class Builder {
        private String ticketId;
        private LocalDateTime entryTime;
        private String floorId;
        private String spotId;
        private Vehicle vehicle;
        private PaymentStatus paymentStatus;

        Builder() {
        }

        public Builder ticketId(String ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public Builder entryTime(LocalDateTime entryTime) {
            this.entryTime = entryTime;
            return this;
        }

        public Builder vehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public Builder floorId(String floorId) {
            this.floorId = floorId;
            return this;
        }

        public Builder spotId(String spotId) {
            this.spotId = spotId;
            return this;
        }

        public Ticket build() {
            return new Ticket(ticketId, entryTime, vehicle, floorId, spotId);
        }
    }

}
