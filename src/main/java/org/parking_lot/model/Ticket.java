package org.parking_lot.model;

import org.parking_lot.enums.PaymentStatus;

import java.time.LocalDateTime;

public class Ticket {
    String id;
    LocalDateTime entryTime;
    String floorId;
    String spotId;
    Vehicle vehicle;
    PaymentStatus paymentStatus;

    public Ticket(String id, LocalDateTime entryTime, Vehicle vehicle, String floorId, String spotId) {
        this.id = id;
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
        return id;
    }

    public String getFloorId(){
        return floorId;
    }

    public String getSpotId(){
        return spotId;
    }

    public static class Builder {
        private String id;
        private LocalDateTime entryTime;
        private String floorId;
        private String spotId;
        private Vehicle vehicle;
        private PaymentStatus paymentStatus;

        Builder() {
        }

        public Builder ticketId(String ticketId){
            this.id = ticketId;
            return this;
        }

        public Builder entryTime(LocalDateTime entryTime){
            this.entryTime = entryTime;
            return this;
        }

        public Builder vehicle(Vehicle vehicle){
            this.vehicle = vehicle;
            return this;
        }

        public Builder floorId(String floorId){
            this.floorId = floorId;
            return this;
        }

        public Builder spotId(String spotId){
            this.spotId = spotId;
            return this;
        }

        public Ticket build(){
            return new Ticket(id, entryTime, vehicle, floorId, spotId);
        }
    }

}
