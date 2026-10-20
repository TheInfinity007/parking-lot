package org.parking_lot.model;

import org.parking_lot.enums.GateType;
import org.parking_lot.service.ParkingLot;

import java.time.LocalDateTime;
import java.util.UUID;

public class EntryGate extends Gate {

    public EntryGate(String id) {
        super(id);
    }

    public Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime) {
        return ParkingLot.getInstance().parkVehicle(vehicle, entryTime);
    }

    @Override
    public GateType getType() {
        return GateType.ENTRY;
    }
}
