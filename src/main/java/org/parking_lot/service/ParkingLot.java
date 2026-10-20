package org.parking_lot.service;

import org.parking_lot.model.Floor;
import org.parking_lot.model.Ticket;
import org.parking_lot.model.Vehicle;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    static private ParkingLot instance;
    Map<String, Floor> floors;
    Map<String, Ticket> activeTickets;
    PricingStrategy pricingStrategy;

    private ParkingLot() {
        this.floors = new HashMap<>();
        this.activeTickets = new HashMap<>();
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }

        return instance;
    }

    void addFloor(){

    }

    Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime){
        return new Ticket();
    }

    Ticket unparkVehicle(Vehicle vehicle, LocalDateTime exitTime, PaymentStrategy paymentMode){
        return new Ticket();
    }
}
