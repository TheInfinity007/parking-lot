package org.parking_lot.model;

import org.parking_lot.enums.GateType;

import java.time.LocalDateTime;
import java.util.UUID;

public class EntryGate extends Gate {

    public EntryGate(String gateId){

        super(GateType.ENTRY, gateId);
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime){

        String ticketId = UUID.randomUUID().toString();
        System.out.println("Vehicle parked. Ticket: " + ticketId);
        return new Ticket(ticketId, entryTime, vehicle);
    }
}
