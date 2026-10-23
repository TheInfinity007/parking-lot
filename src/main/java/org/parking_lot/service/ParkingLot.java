package org.parking_lot.service;

import org.parking_lot.enums.PaymentMode;
import org.parking_lot.enums.PricingStrategyType;
import org.parking_lot.factory.PaymentStrategyFactory;
import org.parking_lot.factory.PricingStrategyFactory;
import org.parking_lot.model.ParkingFloor;
import org.parking_lot.model.ParkingSpot;
import org.parking_lot.model.Ticket;
import org.parking_lot.model.Vehicle;
import org.parking_lot.strategy.payment.PaymentStrategy;
import org.parking_lot.strategy.pricing.PricingStrategy;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static final ParkingLot INSTANCE = new ParkingLot();
    private final Map<String, ParkingFloor> floors = new ConcurrentHashMap<>();
    private final Map<String, Ticket> activeTickets = new ConcurrentHashMap<>();
    private PricingStrategy pricingStrategy;

    private ParkingLot() {
        this.pricingStrategy = PricingStrategyFactory.get(PricingStrategyType.EVENT_BASED);
    }

    public static ParkingLot getInstance() {
        return INSTANCE;
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

    public void unparkVehicle(String ticketId, LocalDateTime exitTime, PaymentMode paymentMode) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            System.out.println("Invalid ticket ID.");
            return;
        }

        double parkingFee = pricingStrategy.calculateFee(ticket.getVehicle().getType(), ticket.getEntryTime(), exitTime);


        PaymentStrategy strategy = PaymentStrategyFactory.get(paymentMode);
        PaymentProcessor processor = new PaymentProcessor(strategy);
        boolean paid = processor.pay(ticket, parkingFee);
        if (!paid) {
            System.out.println("Vehicle cannot exit. Payment unsuccessful.");
            return;
        }

        ParkingSpot spot = floors.get(ticket.getFloorId()).getSpot(ticket.getSpotId());
        spot.vacant();

        activeTickets.remove(ticketId);

        System.out.println("Vehicle exited. Fee charged: Rs " + parkingFee);
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
