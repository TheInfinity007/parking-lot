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
//        if (instance == null) {
//            instance = new ParkingLot();
//        }

        return instance;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void addFloor(ParkingFloor floor) {
        this.floors.put(floor.getId(), floor);
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime) {

        for (ParkingFloor floor : floors.values()) {

            ParkingSpot spot = floor.findAvailableSpots(vehicle.getType());

            if (spot != null) {
                String ticketId = UUID.randomUUID().toString();
                Ticket ticket = Ticket.builder()
                        .ticketId(ticketId)
                        .entryTime(entryTime)
                        .vehicle(vehicle)
                        .floorId(floor.getId())
                        .spotId(spot.getId())
                        .build();

                activeTickets.put(ticketId, ticket);

                System.out.println("Vehicle parked. Ticket: " + ticketId);
                return ticket;
            }
        }

        System.out.println("No spot available for vehicle type: " + vehicle.getType());
        return null;
    }

    public Ticket unparkVehicle(String ticketId, LocalDateTime exitTime, PaymentMode paymentMode) {
        Ticket ticket = activeTickets.get(ticketId);

        ParkingFloor floor = floors.get(ticket.getFloorId());
        ParkingSpot spot = floor.getSpot(ticket.getSpotId());

        //

        spot.vacant();
        activeTickets.remove(ticketId);

        return ticket;
    }

    public void printStatus() {
        for (ParkingFloor floor : floors.values()) {
            System.out.println("Floor " + floor.getId());

            for (ParkingSpot spot : floor.getSpots().values()) {
                System.out.println("  Spot " + spot.getId() + " [" + spot.getAllowedType() + "] - " + (spot.isOccupied() ? "Occupied" : "Free"));
            }
        }
    }
}
