package org.parking_lot.model;

import org.parking_lot.enums.GateType;

import java.time.LocalDateTime;

public class EntryGate extends Gate {

    public EntryGate(String gateId){

        super(GateType.Entry, gateId);
    }

    Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime){
        return new Ticket();
    }
}
