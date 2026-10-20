package org.parking_lot.service;

import org.parking_lot.enums.PaymentMode;
import org.parking_lot.model.ParkingFloor;
import org.parking_lot.model.ParkingSpot;
import org.parking_lot.model.Ticket;
import org.parking_lot.model.Vehicle;
import org.parking_lot.strategy.pricing.PricingStrategy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {
    static private ParkingLot instance;
    Map<String, ParkingFloor> floors;
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

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void addFloor(ParkingFloor floor) {
        this.floors.put(floor.getId(), floor);
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime) {

        String ticketId = UUID.randomUUID().toString();
        System.out.println("Vehicle parked. Ticket: " + ticketId);
        return new Ticket(ticketId, entryTime, vehicle);
    }

    public Ticket unparkVehicle(String ticketId, LocalDateTime exitTime, PaymentMode paymentMode) {
        return new Ticket();
    }

   public void printStatus(){
        for(ParkingFloor floor: floors.values() ){
            System.out.println("Floor " + floor.getId());

            for(ParkingSpot spot: floor.getSpots().values()){
                System.out.println("  Spot " + spot.getId() + " [" + spot.getAllowedType() + "] - " + (spot.isOccupied() ? "Occupied": "Free"));
            }
        }
    }
}
