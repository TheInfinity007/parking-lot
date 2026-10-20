package org.parking_lot.model;

import org.parking_lot.enums.GateType;

import java.time.LocalDateTime;

public class EntryGate extends Gate {

    EntryGate(){
        super(GateType.Entry);
    }

    Ticket parkVehicle(Vehicle vehicle, LocalDateTime entryTime){
        return new Ticket();
    }
}
